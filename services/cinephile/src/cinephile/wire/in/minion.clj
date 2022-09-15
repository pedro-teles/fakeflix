(ns cinephile.wire.in.minion
  (:require [schema.core :as s]
            [fakeflix-schema.schema :as schema]))

(def minion-envelope-skeleton {:customer-id {:schema s/Str :required true}
                               :name        {:schema s/Str :required true}
                               :last-name   {:schema s/Str :required true}
                               :email       {:schema s/Str :required true}
                               :password    {:schema s/Str :required true}})

(s/defschema MinionEnvelope (schema/loose-schema minion-envelope-skeleton))
