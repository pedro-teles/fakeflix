(ns motion-pictures.logic.bored-activity
  (:require [schema.core :as s])
  (:import (java.util UUID)))

(s/defn generate-internal-id :- s/Uuid
  []
  (UUID/randomUUID))