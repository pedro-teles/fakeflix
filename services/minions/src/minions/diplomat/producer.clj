(ns minions.diplomat.producer
  (:require [fakeflix-kafka.producer :as producer]))

(defn produce-minion!
  [message]
  (producer/produce! (str message) :new-minion))
