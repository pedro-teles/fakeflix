(ns steven-spilberg.db.datomic.bored-activity
  (:require [steven-spilberg.models.bored-activity :as m.bored-activity]
            [fakeflix-datomic.datomic :as datomic]
            [schema.core :as s]))

(s/defn insert!
  [bored-activity :- m.bored-activity/BoredActivity]
  (datomic/insert! bored-activity))

(s/defn find-all-activities! :- [m.bored-activity/BoredActivity]
  []
  (datomic/find-entities! '[:find (pull ?activity [*])
                            :where [?activity :bored-activity/activity _]]))
