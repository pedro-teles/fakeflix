(ns motion-pictures.wire.in.bored-activity
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def bored-activity-skeleton {:activity     {:schema s/Str :required true :doc "Bored Activity description"}
                              :type         {:schema s/Str :required true :doc "Bored Activity type"}
                              :participants {:schema s/Int :required true :doc "Number of participants"}})

(s/defschema BoredActivity (schema/loose-schema bored-activity-skeleton))
