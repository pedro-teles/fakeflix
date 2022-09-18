(ns eric-roberts.diplomat.http-server
  (:require [eric-roberts.adapters.person :as adapters.person]
            [eric-roberts.config.project :as config.project]
            [eric-roberts.controllers.person :as controllers.person]
            [eric-roberts.interceptors :refer [handle]]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [schema.core :as s]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(s/defn fetch-all-persons-handler
  [_]
  {:status 200
   :body (-> (controllers.person/fetch-all-persons)
             (adapters.person/model*->out))})

(def routes
  (route/expand-routes
   #{["/api/version"
      :get (handle api-version-handler)
      :route-name :version]

     ["/api/admin/persons"
      :get (handle fetch-all-persons-handler)
      :route-name :fetch-all-persons]}))

(def service-map {::http/routes routes
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})
