(ns scout.core
  (:gen-class)
  (:require [io.pedestal.http :as http]
            [schema.core :as s]
            [scout.config :as config]
            [scout.controllers.film :as controllers.movie]
            [scout.diplomat.http-server :as server]))

(def hours 24)

(defn -main
  [& _]
  (s/set-fn-validation! true)

  (config/start-kafka)
  (config/start-worker controllers.movie/find-films! hours)

  (http/start
   (http/create-server server/service-map)))
