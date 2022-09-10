(ns eric-roberts.db.datomic.bored-activity
  (:require [eric-roberts.models.bored-activity :as m.bored-activity]
            [fakeflix-datomic.datomic :as datomic]
            [schema.core :as s]))

(s/defn insert!
  [bored-activity :- m.bored-activity/BoredActivity]
  (datomic/insert! bored-activity))

(s/defn find-all-activities! :- [m.bored-activity/BoredActivity]
  []
  (datomic/entities '[:find (pull ?activity [*])
                      :where [?activity :bored-activity/activity _]]))
