(ns scout.diplomat.http-client
  (:require [clojure.data.json :as json]
            [org.httpkit.client :as http]
            [schema.core :as s]
            [scout.adapters.film :as adapters.film]
            [scout.config :as config]))

(def urls {:discover/movies "/discover/movie"})

(s/defn discover-films!
  [page :- s/Int]
  (let [response @(http/get (str (:movies-db (:services config/config-file)) (:discover/movies urls))
                            {:query-params {:api_key (System/getenv "API_KEY")
                                            :page page
                                            :language "en-US"
                                            :sort_by "popularity.desc"
                                            :with_watch_monetization_types "flatrate"}})
        json-body (:body response)
        result (json/read-str json-body :key-fn keyword)]
    (adapters.film/in->model* result)))
