(ns demo.notes)


(comment

  ;; vimeo
  [{[:vimeo.video/id 467144004]
    [:vimeo.video/description
     :vimeo.video/name
     :vimeo.video.user.pictures/uri]}]

  [{[:vimeo.video/id 467144004]
    [* :vimeo.video.user.metadata.connections.albums/options]}]

  [{[:spacex.launch/id 67]
    [* :spacex.launch/launch-year]}]



  ;/users/118038002/albums

  [{[:vimeo.user/id 118038002]
    [* :vimeo.albums]}]

  [{[:vimeo.video/id 467144004]
    [:vimeo.video.user.pictures/sizes]}]

  [{[:vimeo.video/id 467144004]
    [:vimeo.album-list/data]}]

  [{[:vimeo.user/id 118038002]
    [:vimeo.album-list/data]}]

  [{[:vimeo.user/id 118038002]
    [{:vimeo.album-list/data [:vimeo.album/uri]}]}]

  ;; Video

  [{[:youtube.video/id "6_mbxaRDA-s"]
    [:youtube.video.snippet/title
     :youtube.video.statistics/view-count]}]


  [{:my-videos
    [:youtube.video.snippet/title
     :youtube.video.statistics/view-count]}]


  ;; Channel


  [{[:youtube.video/id "6_mbxaRDA-s"]
    [:youtube.video.snippet/title
     :youtube.video.snippet/channel-id
     :youtube.video.snippet/channel-title]}]


  ;; Alias youtube.channel/id


  [{[:youtube.video/id "6_mbxaRDA-s"]
    [:youtube.video.snippet/title
     :youtube.channel.snippet/title
     :youtube.video.statistics/view-count
     :youtube.channel.statistics/video-count
     :youtube.channel.statistics/view-count]}]


  ;; Tracer


  ;; Playlist

  [{[:youtube.playlist/id "PLoGBNJiQoqRDSMznObXnqyq5HbOqLucTz"]
    [:youtube.playlist/id
     :youtube.playlist.snippet/title
     :youtube.playlist.snippet/channel-id]}]


  ;; Playlist + Videos (Batching)

  [{[:youtube.playlist/id "PLoGBNJiQoqRDSMznObXnqyq5HbOqLucTz"]
    [:youtube.playlist/id
     :youtube.playlist.snippet/title
     :youtube.playlist.snippet/channel-id
     :youtube.channel.snippet/title
     {:youtube.playlist/items
      [:youtube.video.snippet/title
       :youtube.playlist-item.snippet/title]}
     :youtube.playlist.content-details/item-count]}]


  ;; Multiple Lists (Batching)

  [{[:youtube.user/username "wrocloverb"]
    [:youtube.channel.snippet/title
     {:youtube.channel/playlists
      [:youtube.playlist.snippet/title
       {:youtube.playlist/items
        [:youtube.video.snippet/title]}]}]}]


  ;; Retry HTTP error

  [{[:youtube.video/id "6_mbxaRDA-s"]
    [:youtube.video.file-details/file-name
     :youtube.video.snippet.localized/title
     :youtube.video.snippet/channel-id]}]


  ;; SpaceX

  [{[:spacex.launch/id 67]
    [:spacex.launch/launch-year]}]


  [{[:spacex.launch/id 67]
    [:spacex.launch/launch-year
     :spacex.launch/details
     :spacex.launch/mission-name
     :spacex.launch.launch-site/site-name
     :youtube.channel.snippet/title
     :youtube.video.snippet/title
     :youtube.video.statistics/view-count]}]


  ;; Placeholders

  [{:>/current-mission
    [{[:spacex.launch/id 67]
      [:spacex.launch/launch-year
       :youtube.video.statistics/view-count
       :youtube.channel.statistics/video-count]}]}
   {:>/my-videos
    [{:my-videos
      [:youtube.video.snippet/title
       :youtube.video.statistics/view-count]}]}])


