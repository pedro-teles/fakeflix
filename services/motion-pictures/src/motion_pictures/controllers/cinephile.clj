(ns motion-pictures.controllers.cinephile
  (:require [motion-pictures.diplomat.http-client :as http-client]
            [schema.core :as s]))

(s/defn validate-cinephile-email :- (s/maybe s/Uuid)
  [email :- s/Str]
  (http-client/find-cinephile-by-email email))
