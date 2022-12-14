(ns minions.wire.in.user
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def user-skeleton {:uuid      {:schema s/Str :required true}
                    :firstname {:schema s/Str :required true}
                    :lastname  {:schema s/Str :required true}})

(s/defschema User (schema/loose-schema user-skeleton))

(def user-envelope-skeleton {:data {:schema [User] :required true}})

(s/defschema UserEnvelope (schema/loose-schema user-envelope-skeleton))
