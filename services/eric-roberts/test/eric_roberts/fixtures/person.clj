(ns eric-roberts.fixtures.person)

(def wire-in {:external-id 1
              :name        "Unit Test"
              :biography   "Unit testing"})

(def model {:person/id          #uuid "c0dd92fa-e923-41b5-afc3-f202fce686d5"
            :person/external-id 1
            :person/name        "Unit Test"
            :person/biography   "Unit testing"})
