(ns diplomat-architecture-template.diplomat.producer
  (:require [diplomat-architecture-template.kafka :as kafka]))

(defn produce-greeting!
  [message]
  (kafka/produce! message :greeting))