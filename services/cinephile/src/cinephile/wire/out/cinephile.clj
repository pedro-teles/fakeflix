(ns cinephile.wire.out.cinephile
  (:require [cinephile.models.cinephile :as models.cinephile]
            [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(s/defschema Cinephile (schema/strict-schema models.cinephile/cinephile-skeleton))

(def cinephile-envelope-skeleton {:results {:schema s/Int :required true}
                                  :cinephiles {:schema [Cinephile]}})

(s/defschema CinephileEnvelope (schema/strict-schema cinephile-envelope-skeleton))

(def cinephile-id-envelope-skeleton {:customer-id {:schema s/Uuid :required true}})

(s/defschema CinephileIdEnvelope (schema/strict-schema cinephile-id-envelope-skeleton))
