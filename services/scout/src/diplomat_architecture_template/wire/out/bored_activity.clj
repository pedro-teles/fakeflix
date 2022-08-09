(ns diplomat-architecture-template.wire.out.bored-activity
  (:require [schema.core :as s]))

(def bored-activity-skeleton {:id           s/Uuid
                              :activity     s/Str
                              :type         s/Str
                              :participants s/Int})

(s/defschema BoredActivity bored-activity-skeleton)