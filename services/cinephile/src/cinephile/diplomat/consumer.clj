(ns cinephile.diplomat.consumer)

(defn greeting-handler
  [value]
  (println value))

(def topics {:hello greeting-handler})