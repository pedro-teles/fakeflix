(ns motion-pictures.diplomat.http-server
  (:require
   [io.pedestal.http.body-params :as body-params]
   [motion-pictures.config.project :as config.project]
   [motion-pictures.controllers.cinephile :as controllers.cinephile]
   [motion-pictures.interceptors :refer [handle]]
   [io.pedestal.http :as http]
   [io.pedestal.http.route :as route]
   [schema.core :as s]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(s/defn validate-email-handler
  [{:keys [request]}]
  (let [email (-> request
                 :json-params
                 :email)
        cinephile-id (controllers.cinephile/validate-cinephile-email email)]
    (if cinephile-id
      {:status 200}
      {:status 204})))

(def routes
  (route/expand-routes
   #{["/api/version"
      :get (handle api-version-handler)
      :route-name :version]

     ["/api/cinephile/validate-email"
      :post (handle validate-email-handler)
      :route-name :validate-email]}))

(def service-map {::http/routes routes
                  ::http/host   "0.0.0.0"
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})

(def service
  (-> service-map
    (http/default-interceptors)
    (update ::http/interceptors conj (body-params/body-params))))
