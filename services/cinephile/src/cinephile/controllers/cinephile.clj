(ns cinephile.controllers.cinephile
  (:require [schema.core :as s]
            [cinephile.models.cinephile :as models.cinephile]
            [cinephile.db.datomic.cinephile :as db]))

(s/defn new-minion!
  [cinephile :- models.cinephile/Cinephile]
  (db/insert-if-not-exists! cinephile))
