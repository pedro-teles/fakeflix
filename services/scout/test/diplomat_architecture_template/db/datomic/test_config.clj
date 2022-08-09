(ns diplomat-architecture-template.db.datomic.test-config
  (:require [diplomat-architecture-template.config :as config]))

(def uri "datomic:mem://unit-test")

(defn create-datomic-test []
  (config/create-database uri)
  (config/create-schema uri)
  (config/datomic uri))
