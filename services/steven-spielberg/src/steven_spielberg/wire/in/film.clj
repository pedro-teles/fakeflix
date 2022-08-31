(ns steven-spielberg.wire.in.film
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def film-envelope-skeleton {:external-id   {:schema s/Int :required true}
                             :backdrop-path {:schema s/Str :required true}
                             :poster-path   {:schema s/Str :required true}
                             :title         {:schema s/Str :required true}
                             :overview      {:schema s/Str :required true}
                             :release-date  {:schema s/Str :required true}
                             :vote-average  {:schema schema/FloatNum :required true}})

(s/defschema FilmEnvelope (schema/loose-schema film-envelope-skeleton))
