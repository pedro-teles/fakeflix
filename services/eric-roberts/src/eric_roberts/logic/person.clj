(ns eric-roberts.logic.person
  (:require [eric-roberts.models.person :as models.person]
            [schema.core :as s])
  (:import [java.util UUID]))

(s/defn generate-person-id :- s/Uuid
  [{:person/keys [external-id name biography]} :- models.person/PersonEnvelope]
  (let [film-unique-identity (str external-id name biography)]
    (->> film-unique-identity
         (map byte)
         byte-array
         UUID/nameUUIDFromBytes)))

(s/defn associate-id :- models.person/Person
  [person :- models.person/PersonEnvelope]
  (assoc person :person/id (generate-person-id person)))
