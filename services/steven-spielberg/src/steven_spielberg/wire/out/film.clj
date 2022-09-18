(ns steven-spielberg.wire.out.film
  (:require [schema.core :as s]
            [fakeflix-schema.schema :as schema]
            [steven-spielberg.models.film :as models.film]))

(s/defschema Film (schema/strict-schema models.film/film-skeleton))

(def film-envelope-skeleton {:results {:schema s/Int :required true}
                             :films   {:schema [Film]}})

(s/defschema FilmEnvelope (schema/strict-schema film-envelope-skeleton))
