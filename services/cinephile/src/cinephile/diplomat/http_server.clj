(ns cinephile.diplomat.http-server
  (:require [cinephile.adapters.cinephile :as adapters.cinephile]
            [cinephile.config.project :as config.project]
            [cinephile.controllers.cinephile :as controllers.cinephile]
            [cinephile.interceptors :refer [handle]]
            [io.pedestal.http :as http]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route :as route]
            [schema.core :as s]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(s/defn fetch-all-cinephiles-handler
  [_]
  {:status 200
   :body   (-> (controllers.cinephile/fetch-all-cinephiles)
               (adapters.cinephile/model*->out))})

(s/defn fetch-cinephile-id-by-email-handler
  [{:keys [request]}]
  (let [body (-> request
                 :json-params)
        cinephile-id (controllers.cinephile/fetch-cinephile-id-by-email (:email body))]
    (if-not (nil? cinephile-id)
      {:status 200
       :body (adapters.cinephile/model->out-id cinephile-id)}
      {:status 204})))

(s/defn fetch-cinephile-by-email-and-password-handler
  [{:keys [request]}]
  (let [body (-> request
               :json-params)
        cinephile (controllers.cinephile/fetch-cinephile-by-email-and-password (:email body) (:password body))]))

(def routes
  (route/expand-routes
   #{["/api/version"
      :get (handle api-version-handler)
      :route-name :version]

     ["/api/admin/cinephiles"
      :get (handle fetch-all-cinephiles-handler)
      :route-name :fetch-all-cinephiles]

     ["/api/cinephile/find-by-email"
      :post (handle fetch-cinephile-id-by-email-handler)
      :route-name :fetch-cinephile-id-by-email]

     ["/api/cinephile/find-by-email-and-password"
      :post (handle fetch-cinephile-by-email-and-password-handler)
      :route-name :fetch-cinephile-by-email-and-password]}))

(def service-map {::http/routes routes
                  ::http/host   "0.0.0.0"
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})

(def service
  (-> service-map
      (http/default-interceptors)
      (update ::http/interceptors conj (body-params/body-params))))
