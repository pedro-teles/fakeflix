(ns cinephile.adapters.cinephile
  (:require [cinephile.logic.cinephile :as logic.cinephile]
            [cinephile.models.cinephile :as models.cinephile]
            [cinephile.wire.in.cinephile :as in.cinephile]
            [cinephile.wire.in.minion :as in.minion]
            [cinephile.wire.out.cinephile :as out.cinephile]
            [schema.core :as s])
  (:import [java.util UUID]))

(s/defn minion->cinephile :- models.cinephile/Cinephile
  [{:keys [customer-id name last-name email password]} :- in.minion/MinionEnvelope]
  #:cinephile{:customer-id (UUID/fromString customer-id)
              :name        name
              :last-name   last-name
              :email       email
              :password    password})

(s/defn in->cinephile :- models.cinephile/Cinephile
  [{:keys [name last-name email password]} :- in.cinephile/NewCinephileEnvelope]
  #:cinephile{:customer-id (logic.cinephile/customer-id name last-name email)
              :name        name
              :last-name   last-name
              :email       email
              :password    password})

(s/defn model*->out :- out.cinephile/AllCinephilesEnvelope
  [cinephiles :- [models.cinephile/Cinephile]]
  {:results    (count cinephiles)
   :cinephiles cinephiles})

(s/defn model->out-id :- out.cinephile/CinephileIdEnvelope
  [customer-id :- s/Uuid]
  {:customer-id customer-id})

(s/defn model->out :- out.cinephile/CinephileEnvelope
  [{:cinephile/keys [customer-id name last-name email]} :- models.cinephile/Cinephile]
  {:customer-id customer-id
   :name        name
   :last-name   last-name
   :email       email})
