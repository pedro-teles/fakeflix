(ns eric-roberts.core
  (:gen-class)
  (:require [eric-roberts.config.project :as config.project]
            [eric-roberts.db.datomic.config.config :as db.config]
            [eric-roberts.diplomat.http-server :as server]
            [fakeflix-datomic.config.datomic :as config.datomic]
            [fakeflix-kafka.config :as config.kafka]
            [io.pedestal.http :as http]
            [schema.core :as s]))

(defn -main
  [& _]
  (s/set-fn-validation! true)

  (config.datomic/start-datomic (System/getenv "DATOMIC_SERVER") config.project/application-name (System/getenv "DATOMIC_PASSWORD") :free db.config/schemas)
  (config.kafka/start-kafka config.project/application-name config.project/consumer-topics config.project/producer-topics)

  (http/start
    (http/create-server server/service-map)))
