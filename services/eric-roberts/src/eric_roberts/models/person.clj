(ns eric-roberts.models.person
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def person-envelope-skeleton {:person/external-id {:schema s/Int :required true :doc "Person ID from MoviesDB"}
                               :person/name        {:schema s/Str :required true :doc "Person name"}
                               :person/biography   {:schema s/Str :required true :doc "Person biography"}})

(def person-skeleton (assoc person-envelope-skeleton :person/id {:schema s/Uuid :required true :doc "Person internal ID"}))

(s/defschema Person (schema/strict-schema person-skeleton))

(s/defschema PersonEnvelope (schema/strict-schema person-envelope-skeleton))
