(ns eric-roberts.wire.out.person
  (:require [eric-roberts.models.person :as models.person]
            [schema.core :as s]
            [fakeflix-schema.schema :as schema]))

(s/defschema Person (schema/strict-schema models.person/person-skeleton))

(def person-envelope-skeleton {:results {:schema s/Int :required true}
                               :persons {:schema [Person] :required true}})

(s/defschema PersonEnvelope (schema/strict-schema person-envelope-skeleton))
