(ns motion-pictures.adapters.cinephile
  (:require [schema.core :as s]
            [motion-pictures.wire.in.cinephile :as in.cinephile]))

(s/defn in->customer-id :- (s/maybe s/Uuid)
  [{:keys [customer-id]} :- (s/maybe in.cinephile/CinephileByEmailEnvelope)]
  (when customer-id
    (parse-uuid customer-id)))
