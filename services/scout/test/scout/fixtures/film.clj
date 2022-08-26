(ns scout.fixtures.film)

(def wire-in-film {:id            1
                   :backdrop_path "backdro_path"
                   :poster_path   "post_path"
                   :title         "Film Title"
                   :overview      "Film Overview"
                   :release_date  "2022-08-26"
                   :vote_average  4.90})

(def model {:external-id   1
            :backdrop-path "backdro_path"
            :poster-path   "post_path"
            :title         "Film Title"
            :overview      "Film Overview"
            :release-date  "2022-08-26"
            :vote-average  4.90})

(def wire-in {:results [{:id            1
                         :backdrop_path "backdro_path"
                         :poster_path   "post_path"
                         :title         "Film Title"
                         :overview      "Film Overview"
                         :release_date  "2022-08-26"
                         :vote_average  4.90}
                        {:id            2
                         :backdrop_path "another_backdro_path"
                         :poster_path   "another_post_path"
                         :title         "Another Film Title"
                         :overview      "Another Film Overview"
                         :release_date  "2022-06-15"
                         :vote_average  3.29}]})