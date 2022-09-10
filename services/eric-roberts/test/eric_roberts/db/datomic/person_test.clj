(ns eric-roberts.db.datomic.person-test
  (:require [clojure.test :refer [deftest is testing]]
            [eric-roberts.db.datomic.config.config :as config]
            [eric-roberts.db.datomic.person :as db.person]
            [eric-roberts.fixtures.person :as fixtures]
            [fakeflix-datomic.datomic :as db]
            [fakeflix-datomic.test.datomic :as test.db]
            [matcher-combinators.test :refer [match?]]))

(deftest insert!-test
  (testing "Should insert a person into datomic"
    (test.db/with-datomic-test config/schemas)
    (db.person/insert! fixtures/model)

    (is (=
         1
         (count (db/entities '[:find (pull ?person [*])
                               :where [?person :person/id ?id]]))))))

(deftest find-by-id-test
  (testing "Should return existing person with the given UUID"
    (test.db/with-datomic-test config/schemas)
    (db.person/insert! fixtures/model)

    (is (match?
         {:person/id          #uuid "c0dd92fa-e923-41b5-afc3-f202fce686d5"
          :person/external-id 1
          :person/name        "Unit Test"
          :person/biography   "Unit testing"}
         (db.person/find-by-id #uuid "c0dd92fa-e923-41b5-afc3-f202fce686d5"))))

  (testing "Should return nil when the given UUID doesn't exists"
    (test.db/with-datomic-test config/schemas)
    (db.person/insert! fixtures/model)

    (is (nil? (db.person/find-by-id #uuid "5f151733-c723-44f2-bb97-ca57b86e65d9")))))

(deftest insert-if-not-exists!-test
  (testing "Should insert a person if the given uuid doesn't exists"
    (test.db/with-datomic-test config/schemas)
    (db.person/insert-if-not-exists! fixtures/model)

    (is (=
         1
         (count (db/entities '[:find (pull ?person [*])
                               :where [?person :person/id ?id]])))))

  (testing "Shouldn't insert a person if the given uuid already exists"
    (test.db/with-datomic-test config/schemas)
    (db.person/insert! fixtures/model)
    (db.person/insert-if-not-exists! fixtures/model)

    (is (=
         1
         (count (db/entities '[:find (pull ?person [*])
                               :in $ ?id
                               :where [?person :person/id ?id]] #uuid "c0dd92fa-e923-41b5-afc3-f202fce686d5"))))))
