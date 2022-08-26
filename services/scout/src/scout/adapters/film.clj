(ns scout.adapters.film
  (:require [schema.core :as s]
            [scout.models.film :as models.film]
            [scout.wire.in.film :as in.flm]
            [scout.wire.out.film :as out.film]))

(s/defn in->model :- models.film/Film
  [{:keys [id backdrop_path poster_path title overview release_date vote_average]} :- in.flm/Film]
  {:external-id   id
   :backdrop-path backdrop_path
   :poster-path   poster_path
   :title         title
   :overview      overview
   :release-date  release_date
   :vote-average  vote_average})

(s/defn in->model* :- [models.film/Film]
  [{:keys [results]} :- in.flm/FilmEnvelope]
  (map in->model results))

(s/defn model->out :- out.film/Film
  [film :- models.film/Film]
  (select-keys film [:external-id
                     :backdrop-path
                     :poster-path
                     :title
                     :overview
                     :release-date
                     :vote-average]))