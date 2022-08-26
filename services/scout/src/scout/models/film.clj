(ns scout.models.film
  (:require [schema.core :as s]))

(def film-skeleton {:external-id   s/Int
                    :backdrop-path s/Str
                    :poster-path   s/Str
                    :title         s/Str
                    :overview      s/Str
                    :release-date  s/Str
                    :vote-average  s/Num})

(s/defschema Film film-skeleton)
