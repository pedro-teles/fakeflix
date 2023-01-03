(ns motion-pictures.wire.out.cinephile
  (:require [fakeflix-schema.schema :as schema]
            [motion-pictures.models.cinephile :as models.cinephile]
            [schema.core :as s]))

(def new-cinephile-envelope-skeleton models.cinephile/cinephile-envelope-skeleton)

(s/defschema NewCinephileEnvelope (schema/loose-schema new-cinephile-envelope-skeleton))
