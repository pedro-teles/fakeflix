(ns eric-roberts.wire.in.person
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def person-envelope-skeleton {:external-id {:schema s/Int :required true}
                               :name        {:schema s/Str :required true}
                               :biography   {:schema s/Str :required true}})

(s/defschema PersonEnvelope (schema/loose-schema person-envelope-skeleton))
