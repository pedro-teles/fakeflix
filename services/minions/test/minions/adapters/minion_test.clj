(ns minions.adapters.minion-test
  (:require [clojure.test :refer [deftest is testing]]
            [matcher-combinators.test :refer [match?]]
            [minions.adapters.minion :as adapters.minion]
            [minions.fixtures.minion :as fixtures]))

(def sha-256-hash "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92")

(deftest user->minion-test
  (testing "Should adapt user->minion correctly"
    (is (match? {:customer-id "97dc129d-a489-4d9f-b9b0-deb720a4cd61"
                 :name        "Unit"
                 :last-name   "Test"
                 :email       "unit.test@fakeflix.com"
                 :password    "123456"}
                (adapters.minion/user->minion fixtures/wire-in)))))

(deftest model->out-test
  (testing "Should adapt model->out correctly"
    (is (match? {:customer-id "97dc129d-a489-4d9f-b9b0-deb720a4cd61"
                 :name        "Unit"
                 :last-name   "Test"
                 :email       "unit.test@fakeflix.com"
                 :password    "123456"}
                (adapters.minion/model->out fixtures/model)))))

(deftest model->out-envelope-test
  (testing "Should adapt model->out-envelope correctly"
    (is (match? {:customer-id "97dc129d-a489-4d9f-b9b0-deb720a4cd61"
                 :name        "Unit"
                 :last-name   "Test"
                 :email       "unit.test@fakeflix.com"
                 :password    sha-256-hash}
                (adapters.minion/model->out-envelope fixtures/model sha-256-hash)))))
