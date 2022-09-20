(ns steven-spielberg.logic.film-test
  (:require [clojure.test :refer [deftest is testing]]
            [matcher-combinators.test :refer [match?]]
            [steven-spielberg.fixtures.film :as fixtures.film]
            [steven-spielberg.logic.film :as logic.film]))

(deftest generate-film-id-test
  (testing "Should generate different UUIDs for different films"
    (is (= #uuid "3f4d245f-7613-34c3-9704-fd25804001c3"
           (logic.film/generate-film-id fixtures.film/model)))

    (is (= #uuid "460a6401-842f-3128-a031-3d9baa5b8234"
           (logic.film/generate-film-id (assoc fixtures.film/model :film/title "Another Unit Test"))))))

(deftest associate-id-test
  (testing "Should associate the attribute id on the film schema"
    (is (match? {:film/id            #uuid "3f4d245f-7613-34c3-9704-fd25804001c3"
                 :film/external-id   1
                 :film/backdrop-path "backdrop_path"
                 :film/poster-path   "poster_path"
                 :film/title         "Unit Test"
                 :film/overview      "A film about testing stuff"
                 :film/release-date  "2022-08-31"
                 :film/vote-average  5.0}
                (logic.film/associate-id fixtures.film/model)))

    (is (match? {:film/id            #uuid "460a6401-842f-3128-a031-3d9baa5b8234"
                 :film/external-id   1
                 :film/backdrop-path "backdrop_path"
                 :film/poster-path   "poster_path"
                 :film/title         "Another Unit Test"
                 :film/overview      "A film about testing stuff"
                 :film/release-date  "2022-08-31"
                 :film/vote-average  5.0}
                (logic.film/associate-id (assoc fixtures.film/model :film/title "Another Unit Test"))))))

(deftest sha256-test
  (testing "Should generate the correct SHA-256 string from the given value"
    (is (= "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"
           (logic.film/sha256 "123456")))

    (is (= "cf80cd8aed482d5d1527d7dc72fceff84e6326592848447d2dc0b0e87dfc9a90"
           (logic.film/sha256 "testing")))))
