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

(def me
  (pc/defresolver me [env input]
    {::pc/input  #{:vimeo.video/id}
     ::pc/output (mergev [attrs/me])}
    (api/fetch-me env input)))


;
; need to include as part of input {:page-number 1}, or something like that...
;

(def albums-by-user-id
  (pc/defresolver albums-by-user-id [env input]
    {::pc/input  #{:vimeo.user/id}
     ::pc/output (mergev [attrs/album-list])}
    (api/fetch-album-list-by-user-id env input)))


(defn resolver-alias [from to]
  (pc/resolver (symbol (munge (str from "-" to)))
    {::pc/input #{from} ::pc/output [to]}
    (fn [_ input] {to (get input from)})))


(defn alias-resolvers [aliases]
  (mapv (fn [[k v]] (resolver-alias k v)) aliases))


(defn resolvers []
  (mergev [[video-by-id albums-by-user-id me]
           (alias-resolvers attrs/aliases)]))
