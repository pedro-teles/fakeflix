(ns steven-spielberg.fixtures.film)

(def wire-in {:external-id   1
              :backdrop-path "backdrop_path"
              :poster-path   "poster_path"
              :title         "Unit Test"
              :overview      "A film about testing stuff"
              :release-date  "2022-08-31"
              :vote-average  5.0})

(def model {:film/external-id   1
            :film/backdrop-path "backdrop_path"
            :film/poster-path   "poster_path"
            :film/title         "Unit Test"
            :film/overview      "A film about testing stuff"
            :film/release-date  "2022-08-31"
            :film/vote-average  5.0})
