(ns ^:dev/always demo.cards.workspaces-main
  (:require [com.wsscode.pathom.connect :as pc]
            [com.wsscode.pathom.core :as p]
            [nubank.workspaces.core :as ws]
            [com.wsscode.pathom.viz.workspaces :as pvw]
            [com.wsscode.pathom.diplomat.http :as p.http]
            [com.wsscode.pathom.diplomat.http.fetch :as p.http.fetch]
            [demo.connect.spacex.plugin :as spacex.plugin]
            [demo.connect.youtube.plugin :as youtube.plugin]
            [demo.connect.vimeo.plugin :as vimeo.plugin]
            [demo.secret :as secret]
            [demo.cards.shared-workspaces]
            [nubank.workspaces.card-types.react :as ct.react]
            [demo.connect.vimeo.util :as vimeo.util]
            [demo.connect.vimeo.api :as v.api]
            [cljs.core.async :as async]))


(pc/defresolver my-videos [env input]
  {::pc/output [{:my-videos [:youtube.video/id]}]}
  {:my-videos [{:youtube.video/id "6_mbxaRDA-s"}
               {:youtube.video/id "l5ML_4WnAWg"}
               {:youtube.video/id "oo-7mN9WXTw"}]
   :my-vimeo [{:vimeo.video/id 467144004}]})


(defn app-registry []
  [my-videos])


(defn parser []
  (p/parallel-parser
   {::p/env     {::p/reader                         [p/map-reader pc/parallel-reader pc/ident-reader p/env-placeholder-reader
                                                     pc/all-readers]
                 ::p/placeholder-prefixes           #{">"}
                 ::pc/resolver-dispatch             pc/resolver-dispatch-embedded
                 ::pc/mutate-dispatch               pc/mutation-dispatch-embedded
                 ::p.http/driver                    p.http.fetch/request-async
                 :demo.connect.youtube/access-token secret/youtube-token
                 :demo.connect.vimeo/access-token   secret/vimeo-token
                 ::db                               (atom {})}
    ::p/mutate  pc/mutate-async
    ::p/plugins [p/error-handler-plugin
                 p/request-cache-plugin
                 p/trace-plugin
                 (pc/connect-plugin {::pc/register (app-registry)})
                 (youtube.plugin/init)
                 (spacex.plugin/init)
                 (vimeo.plugin/init)]}))


(ws/defcard simple-parser-demo
  (pvw/pathom-card {::pvw/parser (parser)}))

(defn element [name props & children]
  (apply js/React.createElement name (clj->js props) children))

(def video (atom {:vimeo.video/name "Hello world"}))
(def me (atom {}))
(def albums (atom {}))

(ws/defcard vimeo-test1
  (ct.react/react-card
    (let [txt (:vimeo.video/name @video)]
      (element "div" {} txt))))

(defn fetch-vimeo! []
  (println "entering main/vimeo-test1")
  (async/go
    (let [res (v.api/single-fetch-video-by-id
                {:demo.connect.vimeo/access-token secret/vimeo-token
                 :demo.connect.vimeo/user-id 118038002
                 ::p.http/driver                  p.http.fetch/request-async}
                {:vimeo.video/id 467144004})]

      (let [resres (async/<! res)
            _ (println "main: type resres: " (type resres))]
        ;_ (println "main: result: " resres)]

        (reset! video resres)))))

(defn fetch-me! []
  (async/go
    (let [res (v.api/fetch-me
                {:demo.connect.vimeo/access-token secret/vimeo-token
                 ::p.http/driver                  p.http.fetch/request-async}
                {})]

      (let [resres (async/<! res)
            _ (println "main: type resres: " (type resres))]
        ;_ (println "main: result: " resres)]

        (reset! me resres)))))

(defn fetch-albums! []
  (async/go
    (let [res (v.api/single-fetch-albums-by-user-id
                {:demo.connect.vimeo/access-token secret/vimeo-token
                 ;:demo.connect.vimeo/user-id 118038002
                 ::p.http/driver                  p.http.fetch/request-async}
                {:vimeo.user/id 118038002})]

      (let [resres (async/<! res)
            _ (println "main: type resres: " (type resres))]
        ;_ (println "main: result: " resres)]

        (reset! albums resres)))))





(ws/mount)
