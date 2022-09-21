(ns eric-roberts.logic.person
  (:require [eric-roberts.models.person :as models.person]
            [schema.core :as s])
  (:import [java.security MessageDigest]
           [java.util UUID]))

(s/defn sha256 :- s/Str
  [value :- s/Str]
  (let [digest (.digest (MessageDigest/getInstance "SHA-256") (.getBytes value "UTF-8"))]
    (apply str (map (partial format "%02x") digest))))

(s/defn generate-person-id :- s/Uuid
  [{:person/keys [external-id name biography]} :- models.person/PersonEnvelope]
  (let [film-unique-identity (str external-id name biography)]
    (->> film-unique-identity
         sha256
         (map byte)
         byte-array
         UUID/nameUUIDFromBytes)))

(s/defn associate-id :- models.person/Person
  [person :- models.person/PersonEnvelope]
  (assoc person :person/id (generate-person-id person)))
