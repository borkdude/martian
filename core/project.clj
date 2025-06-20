(defproject com.github.oliyh/martian "0.1.32-SNAPSHOT"
  :description "Client routing for Swagger APIs"
  :url "https://github.com/oliyh/martian"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[frankiesardo/tripod "0.2.0"]
                 [prismatic/schema "1.1.12"]
                 [metosin/schema-tools "0.12.3"]
                 [metosin/spec-tools "0.10.5"
                  :exclusions [com.fasterxml.jackson.core/jackson-databind]]
                 [org.clojure/spec.alpha "0.2.194"]
                 [camel-snake-kebab "0.4.2"]
                 [cheshire "5.10.1"]
                 [clj-commons/clj-yaml "0.7.107"]
                 [lambdaisland/uri "1.12.89"]

                 [com.cognitect/transit-clj "1.0.324"]
                 [com.cognitect/transit-cljs "0.8.269"]
                 [org.flatland/ordered "1.15.12"]
                 [ring/ring-codec "1.2.0"]]
  :java-source-paths ["src"]
  :profiles {:provided {:dependencies [[org.clojure/clojure "1.10.3"]
                                       [org.clojure/clojurescript "1.10.866"]]}
             :dev {:source-paths ["../test-common"]
                   :resource-paths ["test-resources" "../test-common"]
                   :dependencies [[binaryage/devtools "1.0.7"]
                                  [org.clojure/clojurescript "1.12.42"]
                                  [com.bhauman/figwheel-main "0.2.20"]
                                  [cider/piggieback "0.5.2"]
                                  [org.clojure/tools.nrepl "0.2.13"]
                                  [nubank/matcher-combinators "3.8.5"]]
                   :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}}
  :aliases {"fig"       ["trampoline" "run" "-m" "figwheel.main"]
            "fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dist"]
            "fig:test"  ["run" "-m" "figwheel.main" "-co" "test.cljs.edn" "-m" martian.test-runner]
            "test" ["do" ["clean"] ["test"] ["fig:test"]]})
