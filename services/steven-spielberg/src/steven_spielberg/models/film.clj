(ns steven-spielberg.models.film
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def film-envelope-skeleton {:film/external-id   {:schema s/Int :required true :doc "Id generated on The Movies DB"}
                             :film/backdrop-path {:schema s/Str :required true :doc "File name of the backdrop image"}
                             :film/poster-path   {:schema s/Str :required true :doc "File name of the poster image"}
                             :film/title         {:schema s/Str :required true :doc "Film title"}
                             :film/overview      {:schema s/Str :required true :doc "Film overview"}
                             :film/release-date  {:schema s/Str :required true :doc "Film release date"}
                             :film/vote-average  {:schema schema/FloatNum :required true :doc "Vote average from the users"}})

(def film-skeleton (assoc film-envelope-skeleton :film/id {:schema s/Uuid :required true :doc "Internal film id"}))

(s/defschema FilmEnvelope (schema/strict-schema film-envelope-skeleton))

(s/defschema Film (schema/strict-schema film-skeleton))
