(ns steven-spielberg.adapters.film-test
  (:require [clojure.test :refer [deftest is testing]]
            [matcher-combinators.test :refer [match?]]
            [steven-spielberg.adapters.film :as adapters.film]
            [steven-spielberg.fixtures.film :as fixtures.film]))

(deftest in->model-test
  (testing "Should adapt in->model correctly"
    (is (match? {:film/external-id 1
                 :film/backdrop-path "backdrop_path"
                 :film/poster-path "poster_path"
                 :film/title "Unit Test"
                 :film/overview "A film about testing stuff"
                 :film/release-date "2022-08-31"
                 :film/vote-average 5.0}
                (adapters.film/in->model fixtures.film/wire-in)))))
