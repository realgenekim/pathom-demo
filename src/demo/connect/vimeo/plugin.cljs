(ns demo.connect.vimeo.plugin
  (:require [com.wsscode.pathom.connect :as pc]
            [demo.connect.vimeo.resolvers :as resolvers]))

(defn init []
  {::pc/register [(resolvers/resolvers)]})
