(ns minions.wire.out.minion
  (:require [minions.models.minion :as models.minion]
            [schema.core :as s]))

(s/defschema MinionEnvelope models.minion/Minion)

(s/defschema Minion models.minion/Minion)
