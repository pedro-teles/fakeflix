(ns minions.diplomat.http-client
  (:require [clojure.data.json :as json]
            [minions.models.minion :as models.minion]
            [minions.adapters.minion :as adapters.minion]
            [minions.config.project :as config]
            [org.httpkit.client :as http]
            [schema.core :as s]))

(def urls {:users "/users"})

(s/defn fetch-minion :- models.minion/Minion
  []
  (let [response  @(http/get (str (:faker (:services config/config-file)) (:users urls))
                     {:query-params {:_quantity 1}})
        json-body (:body response)
        result    (-> (json/read-str json-body :key-fn keyword)
                    :data
                    first)]
    (adapters.minion/user->minion result)))
