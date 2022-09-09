(ns eric-roberts.diplomat.http-client
  (:require [clojure.data.json :as json]
            [eric-roberts.adapters.bored-activity :as a.bored-activity]
            [eric-roberts.models.bored-activity :as m.bored-activity]
            [org.httpkit.client :as http]
            [schema.core :as s]))

(def urls {:find-bored-activities "https://www.boredapi.com/api/activity"})

(s/defn find-bored-activities! :- m.bored-activity/BoredActivityData
  []
  (let [response @(http/get (:find-bored-activities urls))
        json-body (:body response)
        result (json/read-str json-body :key-fn keyword)]
    (a.bored-activity/in->internal result)))
