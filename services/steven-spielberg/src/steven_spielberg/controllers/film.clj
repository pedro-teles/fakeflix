(ns steven-spielberg.controllers.film
  (:require [schema.core :as s]
            [steven-spielberg.db.datomic.film :as db.film]
            [steven-spielberg.logic.film :as logic.film]
            [steven-spielberg.models.film :as models.film]))

(s/defn new-film!
  [film :- models.film/FilmEnvelope]
  (-> film
      logic.film/associate-id
      db.film/insert-if-not-exists!))

(s/defn fetch-all-films :- [models.film/Film]
  []
  (db.film/fetch-all))
