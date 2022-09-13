(ns minions.models.minion
  (:require [schema.core :as s]
            [fakeflix-schema.schema :as schema]))

(def minion-skeleton {:customer-id {:schema s/Str :required true :doc "Fake minion id"}
                      :name        {:schema s/Str :required true :doc "Fake minion name"}
                      :last-name   {:schema s/Str :required true :doc "Fake minion last name"}
                      :email       {:schema s/Str :required true :doc "Fake minion e-mail"}
                      :password    {:schema s/Str :required true :doc "Fake minion password"}})

(s/defschema Minion (schema/strict-schema minion-skeleton))
