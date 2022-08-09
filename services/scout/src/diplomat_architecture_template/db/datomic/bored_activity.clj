(ns diplomat-architecture-template.db.datomic.bored-activity
  (:require [datomic.api :as d]
            [diplomat-architecture-template.models.bored-activity :as m.bored-activity]
            [schema.core :as s])
  (:import (datomic Connection)
           (datomic.db Db)))

(def schema [{:db/ident       :bored-activity/id
              :db/valueType   :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/doc         "Internal id of bored activity"}
             {:db/ident       :bored-activity/activity
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Bored Activity"}
             {:db/ident       :bored-activity/type
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "Type of Bored Activity"}
             {:db/ident       :bored-activity/participants
              :db/valueType   :db.type/long
              :db/cardinality :db.cardinality/one
              :db/doc         "Number of participants"}])

(s/defn create-schema
  [conn :- Connection]
  (d/transact conn schema))

(s/defn insert!
  [bored-activity :- m.bored-activity/BoredActivity
   conn :- Connection]
  (d/transact conn [bored-activity]))

(s/defn find-all-activities!
  [db :- Db]
  (d/q '[:find (pull ?activity [*])
         :where [?activity :bored-activity/activity _]] db))
