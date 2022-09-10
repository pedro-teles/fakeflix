(ns scout.controllers.person
  (:require [schema.core :as s]
            [scout.adapters.person :as adapters.person]
            [scout.diplomat.http-client :as http-client]
            [scout.diplomat.producer :as producer]))

(s/defn find-persons!
  [film-id :- s/Int]
  (let [cast-ids (http-client/film-cast-ids! film-id)]
    (doseq [id cast-ids]
      (let [person (http-client/person-details! id)]
        (producer/new-person! (adapters.person/model->out person))))))
