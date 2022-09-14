(ns cinephile.controllers.bored-activity
  (:require [cinephile.adapters.bored-activity :as a.bored-activity]
            [cinephile.db.datomic.bored-activity :as db.bored-activity]
            [cinephile.diplomat.http-client :as http-client]
            [cinephile.logic.bored-activity :as l.bored-activity]
            [cinephile.models.bored-activity :as m.bored-activity]
            [schema.core :as s]))

(s/defn tell-me-bored-activity! :- m.bored-activity/BoredActivity
  []
  (let [bored-activity (http-client/find-bored-activities!)
        internal-bored-activity (a.bored-activity/internal-data->internal (l.bored-activity/generate-internal-id) bored-activity)]
    (db.bored-activity/insert! internal-bored-activity)
    internal-bored-activity))

(s/defn all-bored-activities! :- [m.bored-activity/BoredActivity]
  []
  (db.bored-activity/find-all-activities!))
