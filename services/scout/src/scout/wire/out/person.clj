(ns scout.wire.out.person
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]
            [scout.models.person :as models.person]))

(s/defschema Person (schema/strict-schema models.person/person-skeleton))
