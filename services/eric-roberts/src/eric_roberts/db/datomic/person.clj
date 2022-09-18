(ns eric-roberts.db.datomic.person
  (:require [eric-roberts.models.person :as models.person]
            [fakeflix-datomic.datomic :as db]
            [schema.core :as s]))

(s/defn insert!
  [person :- models.person/Person]
  (db/insert! person))

(s/defn find-by-id :- (s/maybe models.person/Person)
  [id :- s/Uuid]
  (-> '[:find (pull ?person [*])
        :in $ ?id
        :where [?person :person/id ?id]]
      (db/entities id)
      first))

(s/defn insert-if-not-exists!
  [{:person/keys [id] :as person} :- models.person/Person]
  (let [existing (find-by-id id)]
    (if (nil? existing)
      (insert! person))))

(s/defn fetch-all-persons
  []
  (db/entities '[:find (pull ?person [*])
                 :where [?person :person/id ?id]]))
