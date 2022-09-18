(ns steven-spielberg.diplomat.consumer
  (:require [clojure.edn :as edn]
            [steven-spielberg.adapters.film :as adapters.film]
            [steven-spielberg.controllers.film :as controllers.film]))

(defn new-film-handler!
  [message]
  (-> message
      edn/read-string
      adapters.film/in->model
      controllers.film/film-received!))

(def topics {:new-film new-film-handler!})
