(defproject clojuretry "0.1.0-SNAPSHOT"
  :description "A simple clojure project"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.520"]
                 [compojure "1.7.1"]
                 [org.typedclojure/typed.clj.runtime "1.2.1"]
                 [ring/ring-core "1.9.5"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.postgresql/postgresql "42.6.0"]
                 [com.zaxxer/HikariCP "4.0.3"]
                 [org.omcljs/om "1.0.0-beta4"]
                 [http-kit "2.6.0"]]

  :source-paths ["src/clj"]
  :aot [backend.core]
  :main backend.core
  :profiles {:dev
             {:dependencies [[org.typedclojure/typed.clj.checker "1.2.1"]
                             [binaryage/devtools "0.9.9"]
                             [cider/piggieback "0.4.2"]
                             [figwheel-sidecar "0.5.19"]
                             [org.clojure/tools.nrepl "0.2.13"]
                             [org.clojure/tools.namespace "0.3.0-alpha4"]]
              :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}})
