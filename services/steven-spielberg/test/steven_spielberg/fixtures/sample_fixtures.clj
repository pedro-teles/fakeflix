(ns steven-spielberg.fixtures.sample-fixtures)

(def in-bored-activity {:activity     "Do an Unit Test"
                        :type         "Programming"
                        :participants 1})

(def internal-bored-activity {:bored-activity/activity     "Do an Unit Test"
                              :bored-activity/type         "Programming"
                              :bored-activity/participants 1})

(def bored-activity (assoc internal-bored-activity :bored-activity/id #uuid "c9f317a4-9647-467f-a941-71d0fa922263"))

(def out-bored-activity (assoc in-bored-activity :id #uuid "c9f317a4-9647-467f-a941-71d0fa922263"))