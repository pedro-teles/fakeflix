(ns steven-spielberg.db.datomic.film
  (:require [fakeflix-datomic.datomic :as datomic]
            [schema.core :as s]
            [steven-spielberg.models.film :as models.film]))

(s/defn insert-film!
  [film :- models.film/Film]
  (datomic/insert! film))

(s/defn fetch-all-films
  []
  (datomic/find-entities! '[:find (pull ?film [*])
                            :where [?film :film/id ?id]]))
