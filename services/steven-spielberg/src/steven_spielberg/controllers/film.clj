(ns steven-spielberg.controllers.film
  (:require [schema.core :as s]
            [steven-spielberg.db.datomic.film :as db.film]
            [steven-spielberg.logic.film :as logic.film]
            [steven-spielberg.models.film :as models.film]))

(s/defn film-received!
  [film :- models.film/FilmEnvelope]
  (let [film-with-id (logic.film/associate-id film)]
    (db.film/insert-film! film-with-id)))

(s/defn fetch-all-films :- [models.film/Film]
  []
  (db.film/fetch-all-films))
