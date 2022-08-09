(ns diplomat-architecture-template.diplomat.consumer)

(defn greeting-handler
  [value]
  (println value))

(def topics {:hello greeting-handler})