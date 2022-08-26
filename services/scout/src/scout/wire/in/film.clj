(ns scout.wire.in.film
  (:require [schema.core :as s]))

(def film-skeleton {:id            s/Int
                    :backdrop_path s/Str
                    :poster_path   s/Str
                    :title         s/Str
                    :overview      s/Str
                    :release_date  s/Str
                    :vote_average  s/Num
                    s/Any          s/Any})

(s/defschema Film film-skeleton)

(def film-envelope-skeleton {:results [Film]
                             s/Any    s/Any})

(s/defschema FilmEnvelope film-envelope-skeleton)
