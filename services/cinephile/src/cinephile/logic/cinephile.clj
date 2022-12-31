(ns cinephile.logic.cinephile
  (:require [schema.core :as s])
  (:import [java.security MessageDigest]
           [java.util UUID]))

(s/defn sha256 :- s/Str
  [value :- s/Str]
  (let [digest (.digest (MessageDigest/getInstance "SHA-256") (.getBytes value "UTF-8"))]
    (apply str (map (partial format "%02x") digest))))

(s/defn customer-id :- s/Uuid
  [name :- s/Str
   last-name :- s/Str
   email :- s/Str]
  (let [customer-unique-identity (str name last-name email)]
    (->> customer-unique-identity
         sha256
         (map byte)
         byte-array
         UUID/nameUUIDFromBytes)))
