(ns motion-pictures.wire.in.cinephile
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def cinephile-by-email-envelope-skeleton {:customer-id {:schema s/Str :required true :doc "Cinephile customer ID"}})

(s/defschema CinephileByEmailEnvelope (schema/loose-schema cinephile-by-email-envelope-skeleton))
