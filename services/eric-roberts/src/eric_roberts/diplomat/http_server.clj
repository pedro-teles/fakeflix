(ns eric-roberts.diplomat.http-server
  (:require [eric-roberts.config.project :as config.project]
            [eric-roberts.interceptors :refer [handle]]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [schema.core :as s]))

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
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})
