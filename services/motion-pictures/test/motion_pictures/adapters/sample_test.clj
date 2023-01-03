(ns motion-pictures.adapters.sample-test
  (:require [clojure.test :refer [deftest is testing]]
            [motion-pictures.adapters.cinephile :as adapters.cinephile]
            [motion-pictures.fixtures.cinephile :as fixtures]))

(deftest cinephile-adapter-test
  (testing "Should adapt in->customer-id correctly"
    (is uuid?
        (adapters.cinephile/in->customer-id fixtures/in-find-cinephile-by-email))

    (is nil?
        (adapters.cinephile/in->customer-id nil))))
