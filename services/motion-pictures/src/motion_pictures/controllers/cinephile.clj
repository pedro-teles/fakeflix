(ns motion-pictures.controllers.cinephile
  (:require [motion-pictures.diplomat.http-client :as http-client]
            [motion-pictures.diplomat.producer :as producer]
            [motion-pictures.models.cinephile :as models.cinephile]
            [schema.core :as s]))

(s/defn validate-cinephile-email :- (s/maybe s/Uuid)
  [email :- s/Str]
  (http-client/find-cinephile-by-email email))

(s/defn register-cinephile!
  [{:keys [email] :as cinephile} :- models.cinephile/CinephileEnvelope]
  (let [is-registered? (-> (validate-cinephile-email email)
                           uuid?)]
    (if-not is-registered?
      (do
        (producer/produce-new-cinephile! cinephile)
        cinephile))))
