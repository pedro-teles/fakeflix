(ns steven-spielberg.diplomat.consumer
  (:require [clojure.edn :as edn]
            [steven-spielberg.adapters.film :as adapters.film]
            [steven-spielberg.controllers.film :as controllers.film]))

(defn film-received-handler!
  [message]
  (-> message
      edn/read-string
      adapters.film/in->model
      controllers.film/film-received!))

(def topics {:film-received film-received-handler!})
