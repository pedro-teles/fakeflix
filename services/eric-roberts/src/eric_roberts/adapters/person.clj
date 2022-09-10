(ns eric-roberts.adapters.person
  (:require [eric-roberts.models.person :as models.person]
            [eric-roberts.wire.in.person :as in.person]
            [schema.core :as s]))

(s/defn in->model :- models.person/PersonEnvelope
  [{:keys [external-id name biography]} :- in.person/PersonEnvelope]
  #:person{:external-id external-id
           :name        name
           :biography   biography})
