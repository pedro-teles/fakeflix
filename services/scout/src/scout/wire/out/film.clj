(ns scout.wire.out.film
  (:require [schema.core :as s]
            [scout.models.film :as models.film]))

(s/defschema Film models.film/film-skeleton)
