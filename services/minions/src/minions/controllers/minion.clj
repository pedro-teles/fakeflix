(ns minions.controllers.minion
  (:require [minions.adapters.minion :as adapters.minion]
            [minions.diplomat.http-client :as client]
            [minions.diplomat.producer :as producer]
            [minions.logic.minion :as logic.minion]
            [schema.core :as s]))

(s/defn minion-data
  []
  (let [minion          (client/fetch-minion)
        hashed-password (logic.minion/sha256 (:password minion))]
    (producer/produce-minion! (adapters.minion/model->out-envelope minion hashed-password))
    (adapters.minion/model->out minion)))
