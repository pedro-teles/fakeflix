(ns scout.diplomat.producer
  (:require [schema.core :as s]
            [scout.kafka :as kafka]
            [scout.wire.out.film :as out.film]))

(s/defn film-received!
  [film :- out.film/Film]
  (kafka/produce! film :film-received))
