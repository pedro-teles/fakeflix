(ns scout.core
  (:require [io.pedestal.http :as http]
            [schema.core :as s]
            [scout.config :as config]
            [scout.controllers.film :as controllers.movie]
            [scout.diplomat.http-server :as server]))

(s/set-fn-validation! true)

(config/start-kafka)

(config/start-worker controllers.movie/find-films! 10)

(http/start
 (http/create-server server/service-map))
