(ns cinephile.adapters.cinephile-test
  (:require [cinephile.adapters.cinephile :as adapters.cinephile]
            [cinephile.fixtures.cinephile :as fixtures]
            [clojure.test :refer [deftest is testing]]
            [matcher-combinators.test :refer [match?]]))

(deftest minion->cinephile-test
  (testing "Should adapt minion->cinephile correctly"
    (is (match? {:cinephile/customer-id #uuid "c789839b-dc7d-48ce-ada2-283c915d2321"
                 :cinephile/name        "Unit"
                 :cinephile/last-name   "McTest"
                 :cinephile/email       "unit.mctest@fakeflix.com"
                 :cinephile/password    "123456"}
                (adapters.cinephile/minion->cinephile fixtures/wire-in)))))
