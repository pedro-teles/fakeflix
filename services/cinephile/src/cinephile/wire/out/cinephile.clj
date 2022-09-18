(ns cinephile.wire.out.cinephile
  (:require [cinephile.models.cinephile :as models.cinephile]
            [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(s/defschema Cinephile (schema/strict-schema models.cinephile/cinephile-skeleton))

(def cinephile-envelope-skeleton {:results {:schema s/Int :required true}
                                  :cinephiles {:schema [Cinephile]}})

(s/defschema CinephileEnvelope (schema/strict-schema cinephile-envelope-skeleton))
