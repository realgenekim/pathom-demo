(ns demo.connect.vimeo.resolvers
  (:require [com.wsscode.pathom.connect :as pc]
            [demo.connect.vimeo.attrs :as attrs]
            [demo.connect.vimeo.api :as api]))


(defn mergev [colls]
  (reduce into [] colls))


(def video-by-id
  (pc/defresolver video-by-id [env input]
    {::pc/input  #{:vimeo.video/id}
     ::pc/output (mergev [attrs/video])}
    (api/single-fetch-video-by-id env input)))


(defn resolver-alias [from to]
  (pc/resolver (symbol (munge (str from "-" to)))
    {::pc/input #{from} ::pc/output [to]}
    (fn [_ input] {to (get input from)})))


(defn alias-resolvers [aliases]
  (mapv (fn [[k v]] (resolver-alias k v)) aliases))


(defn resolvers []
  (mergev [[video-by-id]
           (alias-resolvers attrs/aliases)]))
