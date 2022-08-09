(ns diplomat-architecture-template.controllers.bored-activity
  (:require [diplomat-architecture-template.adapters.bored-activity :as a.bored-activity]
            [diplomat-architecture-template.db.datomic.bored-activity :as db.bored-activity]
            [diplomat-architecture-template.diplomat.http-client :as http-client]
            [diplomat-architecture-template.logic.bored-activity :as l.bored-activity]
            [diplomat-architecture-template.models.bored-activity :as m.bored-activity]
            [schema.core :as s])
  (:import (datomic Connection)))

(s/defn tell-me-bored-activity! :- m.bored-activity/BoredActivity
  [datomic :- Connection]
  (let [bored-activity (http-client/find-bored-activities!)
        internal-bored-activity (a.bored-activity/internal-data->internal (l.bored-activity/generate-internal-id) bored-activity)]
    (db.bored-activity/insert! internal-bored-activity datomic)
    internal-bored-activity))
