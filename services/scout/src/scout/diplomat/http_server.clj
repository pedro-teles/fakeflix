(ns scout.diplomat.http-server
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [schema.core :as s]
            [scout.interceptors :refer [handle]]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(def routes
  (route/expand-routes
   #{["/api/version"
      :get (handle api-version-handler)
      :route-name :version]}))

(def service-map {::http/routes routes
                  ::http/host   "0.0.0.0"
                  ::http/port   8080
                  ::http/type   :jetty
                  ::http/join?  false})
