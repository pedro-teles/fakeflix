(ns steven-spilberg.db.datomic.config.config
  (:require [steven-spilberg.models.bored-activity :as models.bored-activity]))

(def schemas [models.bored-activity/BoredActivity])
