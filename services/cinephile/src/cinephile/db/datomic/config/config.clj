(ns cinephile.db.datomic.config.config
  (:require [cinephile.models.cinephile :as models.cinephile]))

(def schemas [models.cinephile/Cinephile])
