(ns eric-roberts.adapters.person_test
  (:require [clojure.test :refer [deftest is testing]]
            [eric-roberts.adapters.person :as adapters.person]
            [eric-roberts.fixtures.person :as fixtures]
            [matcher-combinators.test :refer [match?]]))

(deftest person-adapter-test
  (testing "Should adapt in->model correctly"
    (is (match? {:person/external-id 1
                 :person/name        "Unit Test"
                 :person/biography   "Unit testing"}
                (adapters.person/in->model fixtures/wire-in)))))
