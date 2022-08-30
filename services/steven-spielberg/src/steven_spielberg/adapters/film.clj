(ns steven-spielberg.adapters.film
  (:require [schema.core :as s]
            [steven-spielberg.models.film :as models.film]
            [steven-spielberg.wire.in.film :as in.film]))

(s/defn in->model :- models.film/FilmEnvelope
  [{:keys [external-id backdrop-path poster-path
           title overview release-date vote-average]} :- in.film/FilmEnvelope]
  #:film{:external-id   external-id
         :backdrop-path backdrop-path
         :poster-path   poster-path
         :title         title
         :overview      overview
         :release-date  release-date
         :vote-average  vote-average})
