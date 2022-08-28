(ns steven-spilberg.adapters.bored-activity
  (:require [steven-spilberg.models.bored-activity :as m.bored-activity]
            [steven-spilberg.wire.in.bored-activity :as in.bored-activity]
            [steven-spilberg.wire.out.bored-activity :as out.bored-activity]
            [schema.core :as s]))

(s/defn in->internal :- m.bored-activity/BoredActivityData
  [{:keys [activity type participants]} :- in.bored-activity/BoredActivity]
  #:bored-activity{:activity     activity
                   :type         type
                   :participants participants})

(s/defn internal-data->internal :- m.bored-activity/BoredActivity
  [internal-id :- s/Uuid
   bored-activity-data :- m.bored-activity/BoredActivityData]
  (assoc bored-activity-data :bored-activity/id internal-id))

(s/defn internal->out :- out.bored-activity/BoredActivity
  [#:bored-activity{:keys [id activity type participants]} :- m.bored-activity/BoredActivity]
  {:id           id
   :activity     activity
   :type         type
   :participants participants})

(s/defn internal->out* :- [out.bored-activity/BoredActivity]
  [activities :- [m.bored-activity/BoredActivity]]
  (map internal->out activities))
