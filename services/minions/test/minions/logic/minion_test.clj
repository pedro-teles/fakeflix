(ns minions.logic.minion-test
  (:require [clojure.test :refer [deftest is testing]]
            [minions.logic.minion :as logic.minion]))

(deftest sha256-test
  (testing "Should generate the correct SHA-256 string from the given value"
    (is (= "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"
           (logic.minion/sha256 "123456")))

    (is (= "cf80cd8aed482d5d1527d7dc72fceff84e6326592848447d2dc0b0e87dfc9a90"
           (logic.minion/sha256 "testing")))))
