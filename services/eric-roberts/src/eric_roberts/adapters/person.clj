(ns eric-roberts.adapters.person
  (:require [eric-roberts.models.person :as models.person]
            [eric-roberts.wire.in.person :as in.person]
            [eric-roberts.wire.out.person :as out.person]
            [schema.core :as s]))

(s/defn in->model :- models.person/PersonEnvelope
  [{:keys [external-id name biography]} :- in.person/PersonEnvelope]
  #:person{:external-id external-id
           :name        name
           :biography   biography})

(s/defn model*->out :- out.person/PersonEnvelope
  [persons :- [models.person/Person]]
  {:results (count persons)
   :persons persons})
