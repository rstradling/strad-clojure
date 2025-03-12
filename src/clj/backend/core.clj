(ns backend.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer [GET defroutes]]
            [compojure.route :as route])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] "Hello from Clojure Backend!")
  (route/not-found "Not Found"))

(defn -main [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    (server/run-server #'app-routes {:port port})
    (println (str "Server running on port " port))))
