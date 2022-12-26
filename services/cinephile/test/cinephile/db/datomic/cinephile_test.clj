(ns cinephile.db.datomic.cinephile-test
  (:require [cinephile.db.datomic.cinephile :as db.cinephile]
            [cinephile.db.datomic.config.config :as db.config]
            [cinephile.fixtures.cinephile :as fixtures]
            [clojure.test :refer [deftest is testing]]
            [fakeflix-datomic.datomic :as datomic]
            [fakeflix-datomic.test.datomic :as test.datomic]
            [matcher-combinators.test :refer [match?]]))

(deftest insert!-test
  (testing "Should insert a cinephile into datomic"
    (test.datomic/with-datomic-test db.config/schemas)
    (db.cinephile/insert! fixtures/model)

    (is (= 1
           (count (datomic/entities '[:find (pull ?cinephile [*])
                                      :where [?cinephile :cinephile/customer-id ?id]]))))

    (is (match? {:cinephile/customer-id #uuid "c789839b-dc7d-48ce-ada2-283c915d2321"
                 :cinephile/name        "Unit"
                 :cinephile/last-name   "McTest"
                 :cinephile/email       "unit.mctest@fakeflix.com"
                 :cinephile/password    "123456"}
                (first (datomic/entities '[:find (pull ?cinephile [*])
                                           :where [?cinephile :cinephile/customer-id ?id]]))))))

(deftest find-by-id-test
  (testing "Should return a cinephile from a existing customer-id"
    (test.datomic/with-datomic-test db.config/schemas)
    (db.cinephile/insert! fixtures/model)

    (is (match? {:cinephile/customer-id #uuid "c789839b-dc7d-48ce-ada2-283c915d2321"
                 :cinephile/name        "Unit"
                 :cinephile/last-name   "McTest"
                 :cinephile/email       "unit.mctest@fakeflix.com"
                 :cinephile/password    "123456"}
                (db.cinephile/find-by-id #uuid "c789839b-dc7d-48ce-ada2-283c915d2321"))))

  (testing "Should return nil from a non-existing customer-id"
    (test.datomic/with-datomic-test db.config/schemas)
    (db.cinephile/insert! fixtures/model)

    (is (nil? (db.cinephile/find-by-id #uuid "118d2dbd-a9e5-444a-8b94-f0faafb05d4b")))))

(deftest insert-if-not-exists!-test
  (testing "Should insert a cinephile when the given customer-id doesn't exists on datomic"
    (test.datomic/with-datomic-test db.config/schemas)
    (db.cinephile/insert-if-not-exists! fixtures/model)

    (is (= 1
           (count (datomic/entities '[:find (pull ?cinephile [*])
                                      :where [?cinephile :cinephile/customer-id ?id]])))))

  (testing "Shouldn't insert a cinephile when the given customer-id already exists on datomic"
    (test.datomic/with-datomic-test db.config/schemas)
    (db.cinephile/insert! fixtures/model)
    (db.cinephile/insert-if-not-exists! fixtures/model)

    (is (= 1
           (count (datomic/entities '[:find (pull ?cinephile [*])
                                      :where [?cinephile :cinephile/customer-id ?id]]))))))

(deftest fetch-by-email-test
  (testing "Should return a cinephile when the given email exists on datomic"
    (test.datomic/with-datomic-test db.config/schemas)
    (db.cinephile/insert! fixtures/model)

    (is (match? {:cinephile/customer-id #uuid "c789839b-dc7d-48ce-ada2-283c915d2321"
                 :cinephile/name        "Unit"
                 :cinephile/last-name   "McTest"
                 :cinephile/email       "unit.mctest@fakeflix.com"
                 :cinephile/password    "123456"}
          (db.cinephile/fetch-by-email "unit.mctest@fakeflix.com"))))

  (testing "Should return nil when email doesn't exists on datomic"
    (test.datomic/with-datomic-test db.config/schemas)
    (db.cinephile/insert! fixtures/model)

    (is (nil? (db.cinephile/fetch-by-email "unknown.email@fakeflix.com")))))

(deftest fetch-by-email-and-password-test
  (testing "Should return a cinephile when the given email and password exists on datomic"
    (test.datomic/with-datomic-test db.config/schemas)
    (db.cinephile/insert! fixtures/model)

    (is (match? {:cinephile/customer-id #uuid "c789839b-dc7d-48ce-ada2-283c915d2321"
                 :cinephile/name        "Unit"
                 :cinephile/last-name   "McTest"
                 :cinephile/email       "unit.mctest@fakeflix.com"
                 :cinephile/password    "123456"}
          (db.cinephile/fetch-by-email-and-password "unit.mctest@fakeflix.com" "123456"))))

  (testing "Should return nil when the given email and password are incorrect"
    (test.datomic/with-datomic-test db.config/schemas)
    (db.cinephile/insert! fixtures/model)

    (is (nil? (db.cinephile/fetch-by-email-and-password "unit.mctest@fakeflix.com" "testing")))))
