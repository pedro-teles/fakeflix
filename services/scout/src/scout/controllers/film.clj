(ns scout.controllers.film
  (:require [schema.core :as s]
            [scout.adapters.film :as adapters.film]
            [scout.controllers.person :as controllers.person]
            [scout.diplomat.http-client :as http-client]
            [scout.diplomat.producer :as producer]))

(s/defn find-films!
  []
  (dotimes [n 10]
    (let [films (http-client/discover-films! (inc n))]
      (doseq [film films]
        (future (controllers.person/find-persons! (:external-id film)))
        (producer/new-film! (adapters.film/model->out film))))))
