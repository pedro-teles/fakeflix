(ns scout.adapters.person
  (:require [schema.core :as s]
            [scout.models.person :as models.person]
            [scout.wire.in.person :as in.person]
            [scout.wire.out.person :as out.person]))

(s/defn in->model :- models.person/Person
  [{:keys [id name biography]} :- in.person/PersonEnvelope]
  {:external-id id
   :name        name
   :biography   biography})

(s/defn model->out :- out.person/Person
  [person :- models.person/Person]
  (select-keys person [:external-id
                       :name
                       :biography]))
