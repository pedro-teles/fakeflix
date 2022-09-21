(defproject steven-spielberg "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[com.github.clojure-lsp/lein-clojure-lsp "1.3.9"]]
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/data.json "2.4.0"]
                 [prismatic/schema "1.2.1"]
                 [io.pedestal/pedestal.service "0.5.10"]
                 [io.pedestal/pedestal.route "0.5.10"]
                 [io.pedestal/pedestal.jetty "0.5.10"]
                 [nubank/matcher-combinators "3.5.1"]
                 [org.clojars.pedroso/fakeflix-kafka "1.0.2"]
                 [org.clojars.pedroso/fakeflix-datomic "1.1.0"]
                 [org.clojars.pedroso/fakeflix-schema "1.0.1"]
                 [http-kit "2.6.0"]]
  :aliases {"diagnostics"  ["clojure-lsp" "diagnostics"]
            "format"       ["clojure-lsp" "format" "--dry"]
            "format-fix"   ["clojure-lsp" "format"]
            "clean-ns"     ["clojure-lsp" "clean-ns" "--dry"]
            "clean-ns-fix" ["clojure-lsp" "clean-ns"]
            "lint"         ["do" ["diagnostics"] ["format"] ["clean-ns"]]
            "lint-fix"     ["do" ["format-fix"] ["clean-ns-fix"]]}
  :profiles {:uberjar {:aot :all}}
  :main steven-spielberg.core
  :repl-options {:init-ns steven-spielberg.core}
  :uberjar-name "steven-spielberg-standalone.jar")
