(ns cinephile.db.datomic.cinephile
  (:require [cinephile.models.cinephile :as models.cinephile]
            [fakeflix-datomic.datomic :as db]
            [schema.core :as s]))

(s/defn insert!
  [cinephile :- models.cinephile/Cinephile]
  (db/insert! cinephile))

(s/defn find-by-id :- (s/maybe models.cinephile/Cinephile)
  [id :- s/Uuid]
  (-> '[:find (pull ?cinephile [*])
        :in $ ?id
        :where [?cinephile :cinephile/customer-id ?id]]
      (db/entities id)
      first))

(s/defn insert-if-not-exists!
  [{:cinephile/keys [customer-id] :as cinephile} :- models.cinephile/Cinephile]
  (let [existing (find-by-id customer-id)]
    (if (nil? existing)
      (insert! cinephile))))
