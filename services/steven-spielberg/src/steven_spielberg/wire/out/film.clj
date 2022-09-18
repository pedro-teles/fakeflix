(ns steven-spielberg.wire.out.film
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]
            [steven-spielberg.models.film :as models.film]))

(s/defschema Film (schema/strict-schema models.film/film-skeleton))

(def film-envelope-skeleton {:results {:schema s/Int :required true}
                             :films   {:schema [Film]}})

(s/defschema FilmEnvelope (schema/strict-schema film-envelope-skeleton))
