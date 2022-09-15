(ns cinephile.controllers.cinephile
  (:require [cinephile.db.datomic.cinephile :as db]
            [cinephile.models.cinephile :as models.cinephile]
            [schema.core :as s]))

(s/defn new-minion!
  [cinephile :- models.cinephile/Cinephile]
  (db/insert-if-not-exists! cinephile))
