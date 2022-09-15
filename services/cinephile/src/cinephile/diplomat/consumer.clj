(ns cinephile.diplomat.consumer
  (:require [clojure.edn :as edn]
            [cinephile.adapters.cinephile :as adapters.cinephile]
            [cinephile.controllers.cinephile :as controllers.cinephile]
            [schema.core :as s]))

(s/defn new-minion-handler!
  [message]
  (-> message
    edn/read-string
    adapters.cinephile/minion->cinephile
    controllers.cinephile/new-minion!))

(def topics {:new-minion new-minion-handler!})
