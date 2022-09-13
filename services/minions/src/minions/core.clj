(ns minions.core
  (:require [fakeflix-kafka.config :as config.kafka]
            [io.pedestal.http :as http]
            [minions.config.project :as config.project]
            [minions.diplomat.http-server :as server]
            [schema.core :as s]))

(s/set-fn-validation! true)

(config.kafka/start-kafka config.project/application-name config.project/consumer-topics config.project/producer-topics)

(http/start
 (http/create-server server/service-map))
