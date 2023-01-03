(ns cinephile.wire.out.cinephile
  (:require [cinephile.models.cinephile :as models.cinephile]
            [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(s/defschema Cinephile (schema/strict-schema models.cinephile/cinephile-skeleton))

(def all-cinephiles-envelope-skeleton {:results    {:schema s/Int :required true}
                                       :cinephiles {:schema [Cinephile]}})

(s/defschema AllCinephilesEnvelope (schema/strict-schema all-cinephiles-envelope-skeleton))

(def cinephile-id-envelope-skeleton {:customer-id {:schema s/Uuid :required true}})

(s/defschema CinephileIdEnvelope (schema/strict-schema cinephile-id-envelope-skeleton))

(def cinephile-envelope-skeleton {:customer-id {:schema s/Uuid :required true :doc "Cinephile id"}
                                  :name        {:schema s/Str :required true :doc "Cinephile name"}
                                  :last-name   {:schema s/Str :required true :doc "Cinephile last name"}
                                  :email       {:schema s/Str :required true :doc "Cinephile e-mail"}})
(s/defschema CinephileEnvelope (schema/strict-schema cinephile-envelope-skeleton))
