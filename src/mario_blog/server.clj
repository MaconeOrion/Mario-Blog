(ns mario-blog.server
  (:require [noir.server :as server]
            [mario-blog.models :as models]))

(server/load-views "src/mario_blog/views/")

(defn -main [& m]
  (let [mode (or (first m) :dev)
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (models/initialize)
    (server/start port {:mode (keyword mode)
                        :ns 'mario-blog})))

