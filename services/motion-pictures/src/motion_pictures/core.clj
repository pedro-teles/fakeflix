(ns motion-pictures.core
  (:require [motion-pictures.config.project :as config.project]
            [motion-pictures.diplomat.http-server :as server]
            [fakeflix-kafka.config :as config.kafka]
            [io.pedestal.http :as http]
            [schema.core :as s]))

(defn -main
  [& _]
  (s/set-fn-validation! true)

  (config.kafka/start-kafka config.project/application-name config.project/consumer-topics config.project/producer-topics)

  (http/start
    (http/create-server server/service-map)))
