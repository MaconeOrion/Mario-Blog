(ns mario-blog.models
  (:require [simpledb.core :as db]
            [mario-blog.models.user :as users]
            [mario-blog.models.post :as posts]))

(defn initialize []
  (db/init)
  (when-not (db/get :users)
    (users/init!)
    (posts/init!)))
