(ns steven-spielberg.db.datomic.film
  (:require [fakeflix-datomic.datomic :as datomic]
            [schema.core :as s]
            [steven-spielberg.models.film :as models.film]))

(s/defn insert!
  [film :- models.film/Film]
  (datomic/insert! film))

(s/defn find-by-id :- (s/maybe models.film/Film)
  [id :- s/Uuid]
  (-> '[:find (pull ?film [*])
        :in $ ?id
        :where [?film :film/id ?id]]
      (datomic/entities id)
      first))

(s/defn insert-if-not-exists!
  [{:film/keys [id] :as film} :- models.film/Film]
  (let [existing (find-by-id id)]
    (if (nil? existing)
      (insert! film))))

(s/defn fetch-all
  []
  (datomic/entities '[:find (pull ?film [*])
                      :where [?film :film/id ?id]]))
