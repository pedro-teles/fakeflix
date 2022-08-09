(ns diplomat-architecture-template.wire.in.bored-activity
  (:require [schema.core :as s]))

(def bored-activity-skeleton {:activity     s/Str
                              :type         s/Str
                              :participants s/Int
                              s/Any         s/Any})

(s/defschema BoredActivity bored-activity-skeleton)
