(ns eric-roberts.adapters.sample-test
  (:require [clojure.test :refer [deftest is testing]]
            [eric-roberts.adapters.bored-activity :as a.bored-activity]
            [eric-roberts.fixtures.sample-fixtures :as fixtures]))

(def internal-id #uuid "c9f317a4-9647-467f-a941-71d0fa922263")

(deftest bored-activity-adapter-test
  (testing "Should adapt in->internal correctly"
    (is (= fixtures/internal-bored-activity
           (a.bored-activity/in->internal fixtures/in-bored-activity))))

  (testing "Should adapt internal-data->internal correctly"
    (is (= fixtures/bored-activity
           (a.bored-activity/internal-data->internal internal-id fixtures/internal-bored-activity))))

  (testing "Should adapter internal->out correctly"
    (is (= fixtures/out-bored-activity
           (a.bored-activity/internal->out fixtures/bored-activity)))))
