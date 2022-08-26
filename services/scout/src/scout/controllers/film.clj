(ns scout.controllers.film
  (:require [schema.core :as s]
            [scout.adapters.film :as adapters.film]
            [scout.diplomat.http-client :as http-client]
            [scout.diplomat.producer :as producer]))

(s/defn find-films!
  []
  (let [films (http-client/discover-films! 1)]
    (doseq [film films]
      (producer/film-received! (adapters.film/model->out film)))))
