(ns motion-pictures.config.project
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [motion-pictures.diplomat.consumer :as diplomat.consumer]
            [org.httpkit.client]
            [org.httpkit.sni-client :as sni-client]))

(def config-file-name "config.edn")

(def config-file (-> config-file-name
                     io/resource
                     slurp
                     edn/read-string))

(def application-name (-> config-file
                          :application-name))

(def server-port (if (nil? (System/getenv "SERVER_PORT"))
                   8080
                   (Integer/parseInt (System/getenv "SERVER_PORT"))))

(defn merge-consumer-handler-fn
  [consumer]
  (let [consumer-key (-> consumer
                         keys
                         first)
        consumer-topic (-> consumer
                           vals
                           first)
        handler-fn (-> diplomat.consumer/topics
                       consumer-key)]
    {consumer-key {:topic      consumer-topic
                   :handler-fn handler-fn}}))

(def producer-topics (->> (get-in config-file [:topics :producers])
                          (reduce merge)))

(def consumer-topics (->> (get-in config-file [:topics :consumers])
                          (map merge-consumer-handler-fn)
                          (reduce merge)))

(alter-var-root #'org.httpkit.client/*default-client* (fn [_] sni-client/default-client))