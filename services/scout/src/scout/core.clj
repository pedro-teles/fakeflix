(ns scout.core
  (:require [scout.config :as config]
            [scout.diplomat.http-server :as server]
            [io.pedestal.http :as http]
            [schema.core :as s]))

(s/set-fn-validation! true)

(config/create-database)
(config/create-schema)
(config/start-kafka)

(http/start
 (http/create-server server/service-map))
