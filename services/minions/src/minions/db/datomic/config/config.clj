(ns minions.db.datomic.config.config
  (:require [minions.models.bored-activity :as models.bored-activity]))

(def schemas [models.bored-activity/BoredActivity])
