(defproject eric-roberts "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[com.github.clojure-lsp/lein-clojure-lsp "1.3.9"]]
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/data.json "2.4.0"]
                 [prismatic/schema "1.2.1"]
                 [org.slf4j/slf4j-simple "1.7.36"]
                 [io.pedestal/pedestal.service "0.5.10"]
                 [io.pedestal/pedestal.route "0.5.10"]
                 [io.pedestal/pedestal.jetty "0.5.10"]
                 [org.apache.kafka/kafka-clients "3.1.0"]
                 [org.apache.kafka/kafka_2.12 "3.1.0"]
                 [org.clojars.pedroso/fakeflix-kafka "1.0.1"]
                 [org.clojars.pedroso/fakeflix-datomic "1.1.0"]
                 [org.clojars.pedroso/fakeflix-schema "1.0.0"]
                 [http-kit "2.6.0"]
                 [com.datomic/datomic-free "0.9.5697"]]
  :aliases {"diagnostics"  ["clojure-lsp" "diagnostics"]
            "format"       ["clojure-lsp" "format" "--dry"]
            "format-fix"   ["clojure-lsp" "format"]
            "clean-ns"     ["clojure-lsp" "clean-ns" "--dry"]
            "clean-ns-fix" ["clojure-lsp" "clean-ns"]
            "lint"         ["do" ["diagnostics"] ["format"] ["clean-ns"]]
            "lint-fix"     ["do" ["format-fix"] ["clean-ns-fix"]]}
  :profiles {:uberjar {:aot :all}}
  :main eric-roberts.core
  :repl-options {:init-ns eric-roberts.core}
  :uberjar-name "eric-roberts-standalone.jar")
