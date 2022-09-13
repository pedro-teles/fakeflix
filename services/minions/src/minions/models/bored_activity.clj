(ns minions.models.bored-activity
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def bored-activity-data-skeleton {:bored-activity/activity     {:schema s/Str :required true :doc "Bored activity description"}
                                   :bored-activity/type         {:schema s/Str :required true :doc "Bored activity type"}
                                   :bored-activity/participants {:schema s/Int :required true :doc "Number of participants"}})

(def bored-activity-skeleton (assoc bored-activity-data-skeleton :bored-activity/id {:schema s/Uuid :required true :doc "Bored activity id"}))

(s/defschema BoredActivityData (schema/strict-schema bored-activity-data-skeleton))

(s/defschema BoredActivity (schema/strict-schema bored-activity-skeleton))
