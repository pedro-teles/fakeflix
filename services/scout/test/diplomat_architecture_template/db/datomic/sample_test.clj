(ns diplomat-architecture-template.db.datomic.sample-test
  (:require [clojure.test :refer [deftest is testing]]
            [datomic.api :as d]
            [diplomat-architecture-template.db.datomic.bored-activity :as db.bored-activity]
            [diplomat-architecture-template.db.datomic.test-config :as test.config]
            [diplomat-architecture-template.fixtures.sample-fixtures :as fixtures]))

(deftest bored-activity-datomic-test
  (testing "Should insert an activity into datomic"
    (let [connection (test.config/create-datomic-test)
          activity fixtures/bored-activity
          _ (db.bored-activity/insert! activity connection)
          result (db.bored-activity/find-all-activities! (d/db connection))]

      (is (= 1
             (count result))))))