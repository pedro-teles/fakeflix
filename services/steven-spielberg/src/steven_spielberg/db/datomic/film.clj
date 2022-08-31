(ns steven-spielberg.db.datomic.film
  (:require [fakeflix-datomic.datomic :as datomic]
            [schema.core :as s]
            [steven-spielberg.models.film :as models.film]))

(s/defn insert-film!
  [film :- models.film/Film]
  (datomic/insert! film))
