(ns motion-pictures.models.cinephile
  (:require [fakeflix-schema.schema :as schema]
            [schema.core :as s]))

(def cinephile-envelope-skeleton {:name      {:schema s/Str :required true :doc "Cinephile name"}
                                  :last-name {:schema s/Str :required true :doc "Cinephile last name"}
                                  :email     {:schema s/Str :required true :doc "Cinephile e-mail"}
                                  :password  {:schema s/Str :required true :doc "Cinephile password"}})

(s/defschema CinephileEnvelope (schema/strict-schema cinephile-envelope-skeleton))
