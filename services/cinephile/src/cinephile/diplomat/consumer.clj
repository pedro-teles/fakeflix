(ns cinephile.diplomat.consumer
  (:require [cinephile.adapters.cinephile :as adapters.cinephile]
            [cinephile.controllers.cinephile :as controllers.cinephile]
            [clojure.edn :as edn]
            [schema.core :as s]))

(s/defn new-minion-handler!
  [message]
  (-> message
      edn/read-string
      adapters.cinephile/minion->cinephile
      controllers.cinephile/new-cinephile!))

(s/defn new-cinephile-handler!
  [message]
  (-> message
      edn/read-string
      adapters.cinephile/in->cinephile
      controllers.cinephile/new-cinephile!))

(def topics {:new-minion new-minion-handler!
             :new-cinephile new-cinephile-handler!})
