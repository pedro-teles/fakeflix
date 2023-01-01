(ns motion-pictures.controllers.cinephile
  (:require [schema.core :as s]
            [motion-pictures.diplomat.http-client :as http-client]))

(s/defn validate-cinephile-email :- (s/maybe s/Uuid)
  [email :- s/Str]
  (http-client/find-cinephile-by-email email))
