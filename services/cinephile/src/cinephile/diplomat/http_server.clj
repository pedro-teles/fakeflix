(ns cinephile.diplomat.http-server
  (:require [cinephile.adapters.bored-activity :as a.bored-activity]
            [cinephile.config.project :as config.project]
            [cinephile.controllers.bored-activity :as c.bored-activity]
            [cinephile.diplomat.producer :as producer]
            [cinephile.interceptors :refer [handle]]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [schema.core :as s]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(s/defn bored-activity-handler
  [_]
  (let [bored-activity (c.bored-activity/tell-me-bored-activity!)]
    {:status 200
     :body (a.bored-activity/internal->out bored-activity)}))

(s/defn all-bored-activity-handler
  [_]
  (let [activities (c.bored-activity/all-bored-activities!)]
    {:status 200
     :body (a.bored-activity/internal->out* activities)}))

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

     ["/api/bored-activity/all"
      :get (handle all-bored-activity-handler)
      :route-name :all-bored-activities]

     ["/api/kafka"
      :get (handle kafka-handler)
      :route-name :kafka]}))

(def service-map {::http/routes routes
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})