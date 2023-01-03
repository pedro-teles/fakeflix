(ns motion-pictures.wire.in.cinephile
  (:require [fakeflix-schema.schema :as schema]
            [motion-pictures.models.cinephile :as models.cinephile]
            [schema.core :as s]))

(def cinephile-by-email-envelope-skeleton {:customer-id {:schema s/Str :required true :doc "Cinephile customer ID"}})

(s/defschema CinephileByEmailEnvelope (schema/loose-schema cinephile-by-email-envelope-skeleton))

(def new-cinephile-envelope-skeleton models.cinephile/cinephile-envelope-skeleton)
(s/defschema NewCinephileEnvelope (schema/loose-schema new-cinephile-envelope-skeleton))
