(ns steven-spielberg.core
  (:require [fakeflix-datomic.config.datomic :as config.datomic]
            [fakeflix-kafka.config :as config.kafka]
            [io.pedestal.http :as http]
            [schema.core :as s]
            [steven-spielberg.config.project :as config.project]
            [steven-spielberg.db.datomic.config.config :as db.config]
            [steven-spielberg.diplomat.http-server :as server]))

(s/set-fn-validation! true)

(config.datomic/start-datomic config.project/application-name (System/getenv "DATOMIC_PASSWORD") :mem db.config/schemas)
(config.kafka/start-kafka config.project/application-name config.project/consumer-topics config.project/producer-topics)

(http/start
 (http/create-server server/service-map))
