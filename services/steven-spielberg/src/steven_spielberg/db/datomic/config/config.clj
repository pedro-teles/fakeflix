(ns steven-spielberg.db.datomic.config.config
  (:require [steven-spielberg.models.film :as models.film]))

(def schemas [models.film/Film])
