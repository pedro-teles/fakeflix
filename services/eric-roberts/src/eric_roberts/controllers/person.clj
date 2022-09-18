(ns eric-roberts.controllers.person
  (:require [eric-roberts.db.datomic.person :as db.person]
            [eric-roberts.logic.person :as logic.person]
            [eric-roberts.models.person :as models.person]
            [schema.core :as s]))

(s/defn new-person
  [person :- models.person/PersonEnvelope]
  (-> person
      logic.person/associate-id
      db.person/insert-if-not-exists!))

(s/defn fetch-all-persons :- [models.person/Person]
  []
  (db.person/fetch-all-persons))
