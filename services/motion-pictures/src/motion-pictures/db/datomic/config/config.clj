(ns motion-pictures.db.datomic.config.config
  (:require [motion-pictures.models.bored-activity :as models.bored-activity]))

(def schemas [models.bored-activity/BoredActivity])
