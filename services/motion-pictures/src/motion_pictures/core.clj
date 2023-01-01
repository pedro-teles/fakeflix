(ns motion-pictures.core
  (:require [motion-pictures.config.project :as config.project]
            [motion-pictures.diplomat.http-server :as server]
            [fakeflix-kafka.config :as config.kafka]
            [motion-pictures.diplomat.http-client :as http.client]
            [io.pedestal.http :as http]
            [schema.core :as s]))

(defn -main
  [& _]
  (s/set-fn-validation! true)

  ;(config.datomic/start-datomic config.project/application-name (System/getenv "DATOMIC_PASSWORD") :mem db.config/schemas)
  (config.kafka/start-kafka config.project/application-name config.project/consumer-topics config.project/producer-topics)

  (http/start
    (http/create-server server/service-map))

  (http.client/find-cinephile-by-email "pedro.teles@fakeflix.com.br"))
