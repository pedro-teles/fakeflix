(ns cinephile.diplomat.http-server
  (:require [cinephile.adapters.cinephile :as adapters.cinephile]
            [cinephile.config.project :as config.project]
            [cinephile.controllers.cinephile :as controllers.cinephile]
            [cinephile.interceptors :refer [handle]]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [schema.core :as s]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(s/defn fetch-all-cinephiles-handler
  [_]
  {:status 200
   :body (-> (controllers.cinephile/fetch-all-cinephiles)
             (adapters.cinephile/model*->out))})

(def routes
  (route/expand-routes
   #{["/api/version"
      :get (handle api-version-handler)
      :route-name :version]

     ["/api/admin/cinephiles"
      :get (handle fetch-all-cinephiles-handler)
      :route-name :fetch-all-cinephiles]}))

(def service-map {::http/routes routes
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})
