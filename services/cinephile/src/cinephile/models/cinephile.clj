(ns cinephile.models.cinephile
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def cinephile-skeleton {:cinephile/customer-id {:schema s/Uuid :required true :doc "Cinephile id"}
                         :cinephile/name        {:schema s/Str :required true :doc "Cinephile name"}
                         :cinephile/last-name   {:schema s/Str :required true :doc "Cinephile last name"}
                         :cinephile/email       {:schema s/Str :required true :doc "Cinephile e-mail"}
                         :cinephile/password    {:schema s/Str :required true :doc "Cinephile password"}})

(s/defschema Cinephile (schema/strict-schema cinephile-skeleton))
