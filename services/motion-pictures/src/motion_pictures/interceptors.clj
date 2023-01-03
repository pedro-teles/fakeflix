(ns motion-pictures.interceptors
  (:require [clojure.data.json :as json]
            [io.pedestal.interceptor :as i]))

(defn json-response
  [context]
  (let [response (:response context)
        json-response (json/write-str (:body response))
        context-with-body (->> {:status (:status response)
                                :body   json-response}
                               (assoc context :response))
        context-with-headers (->> {"Content-Type" "application/json"}
                                  (assoc-in context-with-body [:response :headers]))]
    context-with-headers))

(defn intercept-response
  [context]
  (let [headers (get-in context [:request :headers])
        accept (get headers "accept")]
    (if (= accept "application/json")
      (json-response context)
      context)))

(defn handle
  [handler]
  (i/interceptor
   {:name  ::response-converter
    :enter (fn [context]
             (assoc context :response (handler context)))
    :leave intercept-response}))