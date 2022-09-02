(ns scout.diplomat.producer
  (:require [schema.core :as s]
            [scout.kafka :as kafka]
            [scout.wire.out.film :as out.film]
            [scout.wire.out.person :as out.person]))

(s/defn new-film!
  [film :- out.film/Film]
  (kafka/produce! film :new-film))

(s/defn new-person!
  [person :- out.person/Person]
  (kafka/produce! person :new-person))
