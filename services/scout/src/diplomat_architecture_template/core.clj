(ns diplomat-architecture-template.core
  (:require [diplomat-architecture-template.config :as config]
            [diplomat-architecture-template.diplomat.http-server :as server]
            [io.pedestal.http :as http]
            [schema.core :as s]))

(s/set-fn-validation! true)

(config/create-database)
(config/create-schema)
(config/start-kafka)

(http/start
 (http/create-server server/service-map))
