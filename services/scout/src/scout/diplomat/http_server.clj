(ns scout.diplomat.http-server
  (:require [scout.adapters.bored-activity :as a.bored-activity]
            [scout.config :refer [datomic]]
            [scout.controllers.bored-activity :as c.bored-activity]
            [scout.diplomat.producer :as producer]
            [scout.interceptors :refer [handle]]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [schema.core :as s]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(s/defn bored-activity-handler
  [_]
  (let [datomic (datomic)
        bored-activity (c.bored-activity/tell-me-bored-activity! datomic)]
    {:status 200
     :body (a.bored-activity/internal->out bored-activity)}))

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

     ["/api/bored-activity"
      :get (handle bored-activity-handler)
      :route-name :bored-activities]

     ["/api/kafka"
      :get (handle kafka-handler)
      :route-name :kafka]}))

(def service-map {::http/routes routes
                  ::http/port   8080
                  ::http/type   :jetty
                  ::http/join?  false})
