(ns cinephile.db.datomic.config.config
  (:require [cinephile.models.bored-activity :as models.bored-activity]))

(def schemas [models.bored-activity/BoredActivity])
