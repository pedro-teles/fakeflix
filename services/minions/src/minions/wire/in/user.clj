(ns minions.wire.in.user
  (:require [schema.core :as s]
            [fakeflix-schema.schema :as schema]))

(def user-skeleton {:uuid      {:schema s/Str :required true}
                    :firstname {:schema s/Str :required true}
                    :lastname  {:schema s/Str :required true}})

(s/defschema User (schema/loose-schema user-skeleton))

(def user-envelope-skeleton {:data {:schema [User] :required true}})

(s/defschema UserEnvelope (schema/loose-schema user-envelope-skeleton))
