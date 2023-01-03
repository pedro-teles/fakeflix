(ns motion-pictures.adapters.cinephile
  (:require [motion-pictures.wire.in.cinephile :as in.cinephile]
            [motion-pictures.wire.out.cinephile :as out.cinephile]
            [schema.core :as s]))

(s/defn in->customer-id :- (s/maybe s/Uuid)
  [{:keys [customer-id]} :- (s/maybe in.cinephile/CinephileByEmailEnvelope)]
  (when customer-id
    (parse-uuid customer-id)))

(defn common-cinephile-attributes
  [cinephile]
  (select-keys cinephile [:name
                          :last-name
                          :email
                          :password]))

(s/defn model->out :- out.cinephile/NewCinephileEnvelope
  [cinephile :- motion-pictures.models.cinephile/CinephileEnvelope]
  (common-cinephile-attributes cinephile))

(s/defn in->model :- motion-pictures.models.cinephile/CinephileEnvelope
  [cinephile :- in.cinephile/NewCinephileEnvelope]
  (common-cinephile-attributes cinephile))
