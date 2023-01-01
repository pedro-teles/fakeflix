(ns motion-pictures.diplomat.http-server
  (:require [motion-pictures.config.project :as config.project]
            [motion-pictures.diplomat.producer :as producer]
            [motion-pictures.interceptors :refer [handle]]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [schema.core :as s]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(s/defn kafka-handler
  [_]
  (producer/produce-greeting! "Hello World!")
  {:status 200
   :body nil})

(def routes
  (route/expand-routes
   #{["/api/version"
      :get (handle api-version-handler)
      :route-name :version]

     ["/api/kafka"
      :get (handle kafka-handler)
      :route-name :kafka]}))

(def service-map {::http/routes routes
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})
