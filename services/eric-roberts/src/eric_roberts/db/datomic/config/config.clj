(ns eric-roberts.db.datomic.config.config
  (:require [eric-roberts.models.bored-activity :as models.bored-activity]))

(def schemas [models.bored-activity/BoredActivity])
