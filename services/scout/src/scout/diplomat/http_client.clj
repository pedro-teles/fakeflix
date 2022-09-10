(ns scout.diplomat.http-client
  (:require [clojure.data.json :as json]
            [clojure.string :as str]
            [org.httpkit.client :as http]
            [schema.core :as s]
            [scout.adapters.film :as adapters.film]
            [scout.adapters.person :as adapters.person]
            [scout.config :as config]
            [scout.models.film :as models.film]))

(def urls {:discover/movies "/discover/movie"
           :movie/credits   "/movie/{id}/credits"
           :person "/person/{id}"})

(s/defn discover-films! :- [models.film/Film]
  [page :- s/Int]
  (let [response @(http/get (str (:movies-db (:services config/config-file)) (:discover/movies urls))
                            {:query-params {:api_key                       (System/getenv "API_KEY")
                                            :page                          page
                                            :language                      "en-US"
                                            :sort_by                       "popularity.desc"
                                            :with_watch_monetization_types "flatrate"}})
        json-body (:body response)
        result (json/read-str json-body :key-fn keyword)]
    (adapters.film/in->model* result)))

(s/defn film-cast-ids! :- [s/Int]
  [film-id :- s/Int]
  (let [url (str (:movies-db (:services config/config-file)) (:movie/credits urls))
        url-with-id (str/replace url #"\{id\}" (str film-id))
        response @(http/get url-with-id
                            {:query-params {:api_key (System/getenv "API_KEY")}})
        json-body (:body response)
        result (json/read-str json-body :key-fn keyword)]
    (->> result
         :cast
         (map :id))))

(s/defn person-details!
  [person-id :- s/Int]
  (let [url (str (:movies-db (:services config/config-file)) (:person urls))
        url-with-id (str/replace url #"\{id\}" (str person-id))
        response @(http/get url-with-id
                            {:query-params {:api_key (System/getenv "API_KEY")}})
        json-body (:body response)
        result (json/read-str json-body :key-fn keyword)]
    (adapters.person/in->model result)))
