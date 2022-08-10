(ns scout.diplomat.producer
  (:require [scout.kafka :as kafka]))

(defn produce-greeting!
  [message]
  (kafka/produce! message :greeting))