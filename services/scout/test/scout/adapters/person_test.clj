(ns scout.adapters.person-test
  (:require [clojure.test :refer [deftest is testing]]
            [matcher-combinators.test :refer [match?]]
            [scout.adapters.person :as adapters.person]
            [scout.fixtures.person :as fixtures.person]))

(deftest person-adapter-test
  (testing "Should adapt in->model correctly"
    (is (match? {:external-id 1
                 :name        "Joseph McUnit"
                 :biography   "Test addict"}
                (adapters.person/in->model fixtures.person/wire-in))))

  (testing "Should adapt model->out correctly"
    (is (match? {:external-id 1
                 :name        "Joseph McUnit"
                 :biography   "Test addict"}
                (adapters.person/model->out fixtures.person/model)))))
