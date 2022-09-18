(ns cinephile.wire.out.cinephile
  (:require [cinephile.models.cinephile :as models.cinephile]
            [schema.core :as s]
            [fakeflix-schema.schema :as schema]))

(s/defschema Cinephile (schema/strict-schema models.cinephile/cinephile-skeleton))

(def cinephile-envelope-skeleton {:results {:schema s/Int :required true}
                                  :cinephiles {:schema [Cinephile]}})

(s/defschema CinephileEnvelope (schema/strict-schema cinephile-envelope-skeleton))
