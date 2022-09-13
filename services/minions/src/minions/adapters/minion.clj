(ns minions.adapters.minion
  (:require [schema.core :as s]
            [minions.wire.in.user :as in.user]
            [minions.wire.out.minion :as out.minion]
            [clojure.string :as str]
            [minions.models.minion :as models.minion]))

(s/defn user->minion :- models.minion/Minion
  [{:keys [uuid firstname lastname]} :- in.user/User]
  {:customer-id uuid
   :name        firstname
   :last-name   lastname
   :email       (str (str/lower-case firstname) "." (str/lower-case lastname) "@fakeflix.com")
   :password    "123456"})

(s/defn model->out :- out.minion/Minion
  [minion :- models.minion/Minion]
  (select-keys minion [:customer-id
                       :name
                       :last-name
                       :email
                       :password]))

(s/defn model->out-envelope :- out.minion/MinionEnvelope
  [minion :- models.minion/Minion
   password :- s/Str]
  (-> minion
    (select-keys [:customer-id
                  :name
                  :last-name
                  :email])
    (assoc :password password)))
