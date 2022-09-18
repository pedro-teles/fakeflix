(ns cinephile.adapters.cinephile
  (:require [cinephile.models.cinephile :as models.cinephile]
            [cinephile.wire.in.minion :as in.minion]
            [schema.core :as s])
  (:import [java.util UUID]))

(s/defn minion->cinephile :- models.cinephile/Cinephile
  [{:keys [customer-id name last-name email password]} :- in.minion/MinionEnvelope]
  #:cinephile{:customer-id (UUID/fromString customer-id)
              :name        name
              :last-name   last-name
              :email       email
              :password    password})