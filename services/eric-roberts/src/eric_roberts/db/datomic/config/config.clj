(ns eric-roberts.db.datomic.config.config
  (:require [eric-roberts.models.person :as models.person]))

(def schemas [models.person/Person])
