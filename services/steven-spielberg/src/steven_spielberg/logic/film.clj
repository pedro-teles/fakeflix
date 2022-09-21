(ns steven-spielberg.logic.film
  (:require [schema.core :as s]
            [steven-spielberg.models.film :as models.film])
  (:import [java.security MessageDigest]
           (java.util UUID)))

(s/defn sha256 :- s/Str
  [value :- s/Str]
  (let [digest (.digest (MessageDigest/getInstance "SHA-256") (.getBytes value "UTF-8"))]
    (apply str (map (partial format "%02x") digest))))

(s/defn generate-film-id :- s/Uuid
  [{:film/keys [external-id title release-date]} :- models.film/FilmEnvelope]
  (let [film-unique-identity (str external-id title release-date)]
    (->> film-unique-identity
         sha256
         (map byte)
         byte-array
         UUID/nameUUIDFromBytes)))

(s/defn associate-id :- models.film/Film
  [film :- models.film/FilmEnvelope]
  (assoc film :film/id (generate-film-id film)))
