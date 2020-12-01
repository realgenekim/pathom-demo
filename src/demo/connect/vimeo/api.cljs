(ns demo.connect.vimeo.api
  (:require [com.wsscode.common.async-cljs :refer [<? go-catch]]
            [demo.connect.vimeo.util :as util]))


(defn adapt-video [vimeo]
  vimeo)
  ;(util/adapt-recursive vimeo "vimeo.video"))


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