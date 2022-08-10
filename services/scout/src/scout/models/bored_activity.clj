(ns scout.models.bored-activity
  (:require [schema.core :as s]))

(def bored-activity-data-skeleton {:bored-activity/activity     s/Str
                                   :bored-activity/type         s/Str
                                   :bored-activity/participants s/Int})

(def bored-activity-skeleton (assoc bored-activity-data-skeleton :bored-activity/id s/Uuid))

(s/defschema BoredActivityData bored-activity-data-skeleton)

(s/defschema BoredActivity bored-activity-skeleton)
