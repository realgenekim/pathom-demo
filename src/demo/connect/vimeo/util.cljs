(ns demo.connect.vimeo.util
  (:require [clojure.string :as str]
            [goog.string :as gstr]
            [com.wsscode.common.async-cljs :refer [<? go-catch]]
            [com.wsscode.pathom.diplomat.http :as http]
            [demo.secret :as secret]))

;https://api.vimeo.com/tutorial

(def base-uri "https://api.vimeo.com/")


(defn query-string [params]
  (str/join "&" (map (fn [[k v]] (str (name k) "=" v)) params)))


;(defn vimeo-api [env path data]
;  (go-catch
;    (-> (http/request env
;                      (str base-uri path "?" (query-string data))
;                      {::http/accept ::http/json})
;        <?
;        ::http/body)))

(defn vimeo-params [m]
  (into {} (keep (fn [[k v]]
                   (when (str/starts-with? (str k) ":vimeo.param/")
                     [(gstr/toCamelCase (name k)) v]))) m))

(defn vimeo-api [{:keys [:demo.connect.vimeo/access-token] :as env} path data]
  (if access-token
    (let [data (merge ;{:key access-token}
                      ; (vimeo-params (-> env :ast :params))
                      data)
          gen-path  (str path "/" (:id data))
          query-str ""
          ;(when (not (empty? data))
          ;  "?"
          ;  (query-string data))
          gen-uri (str gen-path query-str)]

      (print "vimeo-api:" access-token)
      ;(println "vimeo-api: env: " env)
      (println "vimeo-api: path: " path)
      (println "vimeo-api: gen-path: " gen-path)
      (println "vimeo-api: data: " data)
      (println "vimeo-api: query-str: " query-str)
      (println "vimeo-api: gen-uri: " gen-uri)

      (go-catch
        (-> (http/request env
                          (str base-uri gen-uri)
                          ;(str base-uri path)
                          {::http/accept ::http/json
                           ::http/headers {"Authorization"
                                           (str "bearer " access-token)}}) <?
            ::http/body)))
    (do
      (js/console.error "Missing youtube token")
      (throw (ex-info "Youtube token not available" {})))))

(defn vimeo-api-123 [{:keys [:demo.connect.vimeo/access-token] :as env} path data]
  (go-catch
    ;(println env)
    (println path)
    (println data)
    (println (str base-uri path "?" (query-string data)))
    (-> (http/request env
                      ;(str base-uri path "?" (query-string data))
                      (str base-uri "videos/467144004")
                      ;"http://google.com"
                      {::http/accept ::http/json})
        <?
        ::http/body)))

(comment
  (vimeo-api-123
    {:demo.connect.vimeo/access-token secret/vimeo-token}
    "videos"
    {:id   "467144004"})

  (go-catch
    (-> (http/request {}
                      "http://google.com"
                      {::http/accept ::http/json})
        <?
        ::http/body))


  ,)



(defn adapt-recursive
  "Pull some key, updating the namespaces of it"
  [x ns]
  (reduce-kv
    (fn [out k v]
      (let [k' (keyword ns (str/replace (name k) "_" "-"))]
        (cond
          (map? v)
          (into out (adapt-recursive v (str ns "." (str/replace (name k) "_" "-"))))

          :else
          (assoc out k' v))))
    {}
    x))
