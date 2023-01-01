(ns motion-pictures.diplomat.producer
  (:require [fakeflix-kafka.producer :as producer]))

(defn produce-greeting!
  [message]
  (producer/produce! message :greeting))