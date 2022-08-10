(ns scout.controllers.bored-activity
  (:require [scout.adapters.bored-activity :as a.bored-activity]
            [scout.db.datomic.bored-activity :as db.bored-activity]
            [scout.diplomat.http-client :as http-client]
            [scout.logic.bored-activity :as l.bored-activity]
            [scout.models.bored-activity :as m.bored-activity]
            [schema.core :as s])
  (:import (datomic Connection)))

(s/defn tell-me-bored-activity! :- m.bored-activity/BoredActivity
  [datomic :- Connection]
  (let [bored-activity (http-client/find-bored-activities!)
        internal-bored-activity (a.bored-activity/internal-data->internal (l.bored-activity/generate-internal-id) bored-activity)]
    (db.bored-activity/insert! internal-bored-activity datomic)
    internal-bored-activity))
