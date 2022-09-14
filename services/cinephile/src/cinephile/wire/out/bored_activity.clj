(ns cinephile.wire.out.bored-activity
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def bored-activity-skeleton {:id           {:schema s/Uuid :required true :doc "Bored Activity id"}
                              :activity     {:schema s/Str :required true :doc "Bored Activity description"}
                              :type         {:schema s/Str :required true :doc "Bored Activity type"}
                              :participants {:schema s/Int :required true :doc "Number of participants"}})

(s/defschema BoredActivity (schema/strict-schema bored-activity-skeleton))
