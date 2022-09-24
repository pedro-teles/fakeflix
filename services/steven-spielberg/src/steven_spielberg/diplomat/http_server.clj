(ns steven-spielberg.diplomat.http-server
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [schema.core :as s]
            [steven-spielberg.adapters.film :as adapters.film]
            [steven-spielberg.config.project :as config.project]
            [steven-spielberg.controllers.film :as controllers.film]
            [steven-spielberg.interceptors :refer [handle]]))

(s/defn api-version-handler
  [_]
  {:status 200
   :body   {:version "0.0.1"}})

(s/defn fetch-all-films
  [_]
  {:status 200
   :body (-> (controllers.film/fetch-all-films)
             (adapters.film/model*->out))})

(def routes
  (route/expand-routes
   #{["/api/version"
      :get (handle api-version-handler)
      :route-name :version]

     ["/api/admin/films"
      :get (handle fetch-all-films)
      :route-name :admin-films]}))

(def service-map {::http/routes routes
                  ::http/host   "0.0.0.0"
                  ::http/port   config.project/server-port
                  ::http/type   :jetty
                  ::http/join?  false})
