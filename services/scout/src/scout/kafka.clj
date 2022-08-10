(ns scout.kafka
  (:require [scout.config :as config])
  (:import [org.apache.kafka.clients.producer ProducerRecord]
           (org.apache.kafka.common Uuid)))

(defn get-topic
  [topic-key]
  (->> config/producers
       (filter #(= (first (keys %)) topic-key))
       first
       topic-key))

(defn produce!
  [message topic]
  (.send config/producer (ProducerRecord. (get-topic topic) (str (Uuid/randomUuid)) message)))