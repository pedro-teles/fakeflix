(ns minions.diplomat.http-server
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [minions.config.project :as config.project]
            [minions.controllers.minion :as controllers.minion]
            [minions.interceptors :refer [handle]]
            [schema.core :as s]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(s/defn minion-handler
  [_]
  (let [minion (controllers.minion/minion-data)]
    {:status 201
     :body minion}))

(def routes
  (route/expand-routes
   #{["/api/version"
      :get (handle api-version-handler)
      :route-name :version]

     ["/api/minion"
      :get (handle minion-handler)
      :route-name :minion]}))

(def service-map {::http/routes routes
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})
