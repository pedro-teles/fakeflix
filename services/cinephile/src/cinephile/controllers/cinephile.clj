(ns cinephile.controllers.cinephile
  (:require [cinephile.db.datomic.cinephile :as db]
            [cinephile.models.cinephile :as models.cinephile]
            [schema.core :as s]))

(s/defn new-minion!
  [cinephile :- models.cinephile/Cinephile]
  (db/insert-if-not-exists! cinephile))

(s/defn fetch-all-cinephiles :- [models.cinephile/Cinephile]
  []
  (db/fetch-all-cinephiles))

(s/defn fetch-cinephile-id-by-email :- (s/maybe s/Uuid)
  [email :- s/Str]
  (-> email
      db/fetch-by-email
      :cinephile/customer-id))

(s/defn fetch-cinephile-by-email-and-password :- (s/maybe models.cinephile/Cinephile)
  [email :- s/Str
   password :- s/Str])
