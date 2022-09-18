(ns scout.config
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [org.httpkit.client]
            [org.httpkit.sni-client :as sni-client])
  (:import (org.apache.kafka.clients.admin AdminClientConfig KafkaAdminClient NewTopic)
           (org.apache.kafka.clients.consumer KafkaConsumer)
           (org.apache.kafka.clients.producer KafkaProducer)
           (org.apache.kafka.common.serialization StringDeserializer StringSerializer)))

(def application-name "scout")

(def kafka-server (if (System/getenv "KAFKA_SERVER") (System/getenv "KAFKA_SERVER") "localhost:9092"))

(def config-file-name "config.edn")

(defn build-consumer ^KafkaConsumer
  []
  (let [consumer-props
        {"bootstrap.servers",  kafka-server
         "group.id",           application-name
         "key.deserializer",   StringDeserializer
         "value.deserializer", StringDeserializer
         "auto.offset.reset",  "earliest"
         "enable.auto.commit", "true"}]
    (KafkaConsumer. consumer-props)))

(defn build-producer ^KafkaProducer
  ;"Create the kafka producer to send on messages received"
  []
  (let [producer-props {"bootstrap.servers" kafka-server
                        "value.serializer"  StringSerializer
                        "key.serializer"    StringSerializer}]
    (KafkaProducer. producer-props)))

(defn create-topic!
  [topics ^Integer partition ^Short replication]
  (let [config {AdminClientConfig/BOOTSTRAP_SERVERS_CONFIG kafka-server}
        adminClient (KafkaAdminClient/create config)
        new-topics (map (fn [^String topic-name]
                          (NewTopic. topic-name partition replication)) topics)]
    (.createTopics adminClient new-topics)))

(defn consumer-subscribe
  [consumer topic]
  (.subscribe consumer topic))

(def producer (build-producer))

(defn topic
  [value]
  (-> value
      vals
      first))

(def config-file (-> config-file-name
                     io/resource
                     slurp
                     edn/read-string))

(def producers (get-in config-file [:topics :producers]))

(def consumers (get-in config-file [:topics :consumers]))

(defn start-kafka
  []
  (let [topics (into (mapv topic producers) (mapv topic consumers))]
    (create-topic! topics 1 1)))

(defn worker
  [fn n]
  (while true
    (try
      (fn)
      (catch Exception e (println e)))
    (Thread/sleep (* n (* 1000 60)))))

(defn start-worker
  [worker-fn every-n-minutes]
  (future (worker worker-fn every-n-minutes)))

(alter-var-root #'org.httpkit.client/*default-client* (fn [_] sni-client/default-client))
