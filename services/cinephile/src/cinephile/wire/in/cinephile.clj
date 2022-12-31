(ns cinephile.wire.in.cinephile
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def new-cinephile-envelope-skeleton {:name      {:schema s/Str :required true :doc "Cinephile name"}
                                      :last-name {:schema s/Str :required true :doc "Cinephile last name"}
                                      :email     {:schema s/Str :required true :doc "Cinephile e-mail"}
                                      :password  {:schema s/Str :required true :doc "Cinephile password"}})

(s/defschema NewCinephileEnvelope (schema/loose-schema new-cinephile-envelope-skeleton))
