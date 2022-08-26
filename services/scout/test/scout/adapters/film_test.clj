(ns scout.adapters.film-test
  (:require [clojure.test :refer [deftest is testing]]
            [matcher-combinators.test :refer [match?]]
            [scout.adapters.film :as adapters.film]
            [scout.fixtures.film :as fixtures]))

(deftest film-adapter-test
  (testing "Should adapt in->model correctly"
    (is (match? {:external-id   1
                 :backdrop-path "backdro_path"
                 :poster-path   "post_path"
                 :title         "Film Title"
                 :overview      "Film Overview"
                 :release-date  "2022-08-26"
                 :vote-average  4.90}
                (adapters.film/in->model fixtures/wire-in-film))))

  (testing "Should adapt in->model* correctly"
    (is (match? [{:external-id   1
                  :backdrop-path "backdro_path"
                  :poster-path   "post_path"
                  :title         "Film Title"
                  :overview      "Film Overview"
                  :release-date  "2022-08-26"
                  :vote-average  4.90}
                 {:external-id   2
                  :backdrop-path "another_backdro_path"
                  :poster-path   "another_post_path"
                  :title         "Another Film Title"
                  :overview      "Another Film Overview"
                  :release-date  "2022-06-15"
                  :vote-average  3.29}]
                (adapters.film/in->model* fixtures/wire-in))))

  (testing "Should adapter model->out correctly"
    (is (match? {:external-id   1
                 :backdrop-path "backdro_path"
                 :poster-path   "post_path"
                 :title         "Film Title"
                 :overview      "Film Overview"
                 :release-date  "2022-08-26"
                 :vote-average  4.90}
                (adapters.film/model->out fixtures/model)))))
