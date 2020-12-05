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
            [com.wsscode.common.async-cljs :refer [<? go-catch]]
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

;
; ^^ the function above requires no arguments
;
; how do I create a parser that I can run from the REPL?
;


(def intparser
  (p/parser
    {::p/env     {::p/reader                         [p/map-reader
                                                      ;pc/parallel-reader
                                                      pc/all-async-readers
                                                      ;pc/async-reader2
                                                      p/ident-join-reader
                                                      (p/placeholder-reader)]
                                                      ;pc/ident-reader
                                                      ;p/env-placeholder-reader
                                                      ;pc/all-readers]
                  ::p/placeholder-prefixes           #{">"}
                  ;::pc/resolver-dispatch             pc/resolver-dispatch-embedded
                  ;::pc/mutate-dispatch               pc/mutation-dispatch-embedded
                  ;::p.http/driver                    p.http.fetch/request-async
                  :demo.connect.youtube/access-token secret/youtube-token
                  :demo.connect.vimeo/access-token   secret/vimeo-token
                  ::db                               (atom {})}
     ;::p/mutate  pc/mutate-async
     ::p/plugins [p/error-handler-plugin
                  ;p/request-cache-plugin
                  p/trace-plugin
                  (pc/connect-plugin {::pc/register (app-registry)})
                  (youtube.plugin/init)
                  (spacex.plugin/init)
                  (vimeo.plugin/init)]}))

(defn q []
  (intparser {} [{[:vimeo.user/id 118038002]
                  [{:vimeo.album-list/data [:vimeo.album/uri]}]}]))

(comment

  (q)
  ;=> {[:vimeo.user/id 118038002]
  ;    {:vimeo.album-list/data
  ;      #object[cljs.core.async.impl.channels.ManyToManyChannel]}}



  ;;; YESTERDAY

  (def x (intparser {} [{[:vimeo.user/id 118038002]
                         [{:vimeo.album-list/data [:vimeo.album/uri]}]}]))

  ; => #object[cljs.core.async.impl.channels.ManyToManyChannel]
  ;
  ; that worked, right?  so, how do I get the result of the query out?

  (go (println (async/<! x)))
  (go-catch (js.console/log (async/<? q)))
  (q)

  (js/console.log "hello")

  ; TypeError: Cannot read property 'call' of undefined
  ;    at eval (eval at <anonymous> (http://localhost:8087/js/cljs-runtime/shadow.cljs.devtools.client.browser.js:823:8), <anonymous>:1:31)


  (go (async/<! (intparser {} [{[:vimeo.user/id 118038002]
                                [{:vimeo.album-list/data [:vimeo.album/uri]}]}]))))

  ; TypeError: Cannot read property 'call' of undefined
  ;    at eval (eval at <anonymous> (http://localhost:8087/js/cljs-runtime/shadow.cljs.devtools.client.browser.js:823:8), <anonymous>:1:31)




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
    (let [res (v.api/fetch-album-list-by-user-id
                {:demo.connect.vimeo/access-token secret/vimeo-token
                 ;:demo.connect.vimeo/user-id 118038002
                 ::p.http/driver                  p.http.fetch/request-async}
                {:vimeo.user/id 118038002})]

      (let [resres (async/<! res)
            _ (println "main: type resres: " (type resres))]
        ;_ (println "main: result: " resres)]

        (reset! albums resres)))))


(comment

  (intparser {} [{[:vimeo.user/id 118038002]
                  [{:vimeo.album-list/data [:vimeo.album/uri]}]}])

  (go (async/<! (intparser {} [{[:vimeo.user/id 118038002]
                                [{:vimeo.album-list/data [:vimeo.album/uri]}]}])))

  (pc/data->shape ...))


(ws/mount)
