(ns scout.models.person
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def person-skeleton {:external-id {:schema s/Int :required true :doc "Person ID from MoviesDB"}
                      :name        {:schema s/Str :required true :doc "Person name"}
                      :biography   {:schema s/Str :required true :doc "Person biography"}})

(s/defschema Person (schema/strict-schema person-skeleton))
