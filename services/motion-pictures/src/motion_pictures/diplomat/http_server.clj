(ns motion-pictures.diplomat.http-server
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route :as route]
            [motion-pictures.adapters.cinephile :as adapters.cinephile]
            [motion-pictures.config.project :as config.project]
            [motion-pictures.controllers.cinephile :as controllers.cinephile]
            [motion-pictures.interceptors :refer [handle]]
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

(s/defn register-cinephile-handler
  [{:keys [request]}]
  (let [body (-> request
                 :json-params)
        cinephile-registered? (-> body
                                  adapters.cinephile/in->model
                                  controllers.cinephile/register-cinephile!)]
    (if cinephile-registered?
      {:status 201}
      {:status 409})))

(def routes
  (route/expand-routes
   #{["/api/version"
      :get (handle api-version-handler)
      :route-name :version]

     ["/api/cinephile/validate-email"
      :post (handle validate-email-handler)
      :route-name :validate-email]

     ["/api/cinephile/register"
      :put (handle register-cinephile-handler)
      :route-name :register-cinephile]}))

(def service-map {::http/routes routes
                  ::http/host   "0.0.0.0"
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})

(def service
  (-> service-map
      (http/default-interceptors)
      (update ::http/interceptors conj (body-params/body-params))))
