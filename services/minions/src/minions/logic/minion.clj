(ns minions.logic.minion
  (:require [schema.core :as s])
  (:import [java.security MessageDigest]))

(s/defn sha256 :- s/Str
  [value :- s/Str]
  (let [digest (.digest (MessageDigest/getInstance "SHA-256") (.getBytes value "UTF-8"))]
    (apply str (map (partial format "%02x") digest))))
