(ns eric-roberts.controllers.bored-activity
  (:require [eric-roberts.adapters.bored-activity :as a.bored-activity]
            [eric-roberts.db.datomic.bored-activity :as db.bored-activity]
            [eric-roberts.diplomat.http-client :as http-client]
            [eric-roberts.logic.bored-activity :as l.bored-activity]
            [eric-roberts.models.bored-activity :as m.bored-activity]
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
