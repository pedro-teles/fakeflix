(ns motion-pictures.adapters.cinephile
  (:require [motion-pictures.wire.in.cinephile :as in.cinephile]
            [schema.core :as s]))

(s/defn in->customer-id :- (s/maybe s/Uuid)
  [{:keys [customer-id]} :- (s/maybe in.cinephile/CinephileByEmailEnvelope)]
  (when customer-id
    (parse-uuid customer-id)))
