(ns motion-pictures.diplomat.producer
  (:require [fakeflix-kafka.producer :as producer]
            [motion-pictures.adapters.cinephile :as adapters.cinephile]
            [motion-pictures.models.cinephile :as models.cinephile]
            [schema.core :as s]))

(s/defn produce-new-cinephile!
  [cinephile :- models.cinephile/CinephileEnvelope]
  (producer/produce! (str (adapters.cinephile/model->out cinephile)) :new-cinephile))
