(ns eric-roberts.diplomat.consumer
  (:require [clojure.edn :as edn]
            [eric-roberts.adapters.person :as adapters.person]
            [eric-roberts.controllers.person :as controllers.person]))

(defn new-person-handler
  [message]
  (-> message
      edn/read-string
      adapters.person/in->model
      controllers.person/new-person))

(def topics {:new-person new-person-handler})
