(ns demo.connect.vimeo.api
  (:require [com.wsscode.common.async-cljs :refer [<? go-catch]]
            [demo.connect.vimeo.util :as util]
            [demo.secret :as secret]))


(defn adapt-video [vimeo]
  (util/adapt-recursive vimeo "vimeo.video"))

(defn adapt-me [vimeo]
  (util/adapt-recursive vimeo "vimeo.me"))

(defn adapt-album [vimeo]
  (util/adapt-recursive vimeo "vimeo.album"))

(defn adapt-album-list [vimeo]
  (util/adapt-recursive vimeo "vimeo.album-list"))


;(defn single-fetch-launch [env input]
;  (let [{:keys [:spacex.launch/id]} input]
;    (go-catch
;      (-> (util/spacex-api env (str "launches/" id) {})
;          <?
;          adapt-launch))))

(defn single-fetch-video-by-id [env input]
  (let [{:keys [:vimeo.video/id]} input]
    (println "single-fetch-video-by-id: id: " id)
    (go-catch
      (-> (util/vimeo-api env (str "videos/" id) {})
          <?
          adapt-video))))

(defn fetch-me [env input]
  (let [_ nil]
    (println "fetch-me: ")
    (go-catch
      (-> (util/vimeo-api env (str "" nil) {})
          <?
          adapt-me))))

; /users/118038002/albums

(defn fetch-album-list-by-user-id [env input]
  (let [{:keys [:vimeo.user/id]} input]
    (println "album-list-by-user-id: user-id: " id)
    (go-catch
      (-> (util/vimeo-api env (str "/users/" id "/albums") {})
          <?
          (merge {:id id})
          ; must update before we rename :data key with namespace
          ; put key :user-id
          (update :data (fn [m]
                          (mapv #(merge % {:user-id id})
                                m)))
          (update :data #(mapv adapt-album %))
          adapt-album-list))))

(comment
  (single-fetch-albums-by-user-id
    {:demo.connect.vimeo/access-token   secret/vimeo-token}
    {:vimeo.user/id 118038002}))

;(defn single-fetch-playlist-by-channel-id [env playlist-output input]
;  (let [{:keys [:youtube.channel/id]} input]
;    (go-catch
;      (->> (util/youtube-api env "playlists"
;                             {:channelId id
;                              :part      (util/request-parts
;                                            (assoc env ::util/parts-query (-> env :ast :query)
;                                                         ::p/entity (util/output->blank-entity playlist-output))
;                                            "youtube.playlist")}) <?
;           :items
;           (mapv adapt-playlist)
;           (hash-map :youtube.channel/playlists)))))