(ns motion-pictures.diplomat.http-client
  (:require [clojure.data.json :as json]
            [motion-pictures.config.project :as config]
            [motion-pictures.adapters.cinephile :as adapters.cinephile]
            [org.httpkit.client :as http]
            [schema.core :as s]))

(def urls {:find-by-email "/api/cinephile/find-by-email"})

(s/defn find-cinephile-by-email :- (s/maybe s/Uuid)
  [email :- s/Str]
  (let [response  @(http/request {:url     (str (:cinephile (:services config/config-file)) (:find-by-email urls))
                                  :method  :post
                                  :headers {"Content-Type" "application/json"
                                            "accept"       "application/json"}
                                  :body    (json/write-str {:email email})})
        json-body (:body response)
        result    (when-not (empty? json-body) (json/read-str json-body :key-fn keyword))]
    (adapters.cinephile/in->customer-id result)))
