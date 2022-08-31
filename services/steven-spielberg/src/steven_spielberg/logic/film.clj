(ns steven-spielberg.logic.film
  (:require [schema.core :as s]
            [steven-spielberg.models.film :as models.film])
  (:import (java.util UUID)))

(s/defn generate-film-id :- s/Uuid
  [{:film/keys [external-id title release-date]} :- models.film/FilmEnvelope]
  (let [film-unique-identity (str external-id title release-date)]
    (->> film-unique-identity
         (map byte)
         byte-array
         UUID/nameUUIDFromBytes)))

(s/defn associate-id :- models.film/Film
  [film :- models.film/FilmEnvelope]
  (assoc film :film/id (generate-film-id film)))
