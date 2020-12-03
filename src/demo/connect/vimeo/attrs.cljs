(ns demo.connect.vimeo.attrs)

(def aliases
  {:vimeo.user/id :vimeo.album/user-id})



; :vimeo.video.user/uri "/users/118038002",

;(def aliases
;  {:youtube.video.snippet/channel-id                   :youtube.channel/id
;   :youtube.playlist.snippet/channel-id                :youtube.channel/id
;   :youtube.playlist-item.content-details/video-id     :youtube.video/id
;   :youtube.playlist-item.snippet.resource-id/video-id :youtube.video/id
;   :youtube.playlist-item.snippet/channel-id           :youtube.channel/id
;   :youtube.playlist-item.snippet/playlist-id          :youtube.playlist/id})

(def me
  [{:vimeo.me/endpoints [:methods :path]}])

(def video
  [:vimeo.user/id
   :vimeo.video/id
   :vimeo.video/categories
   :vimeo.video/content-rating
   :vimeo.video/created-time
   :vimeo.video/description
   :vimeo.video/duration
   :vimeo.video/height
   :vimeo.video/is-playable
   :vimeo.video/language
   :vimeo.video/last-user-action-event-date
   :vimeo.video/license
   :vimeo.video/link
   :vimeo.video/modified-time
   :vimeo.video/name
   :vimeo.video/parent-folder
   :vimeo.video/release-time
   :vimeo.video/resource-key
   :vimeo.video/status
   {:vimeo.video/tags [:canonical
                       {:metadata [{:connections [{:videos [:options :total :uri]}]}]}
                       :name
                       :resource_key
                       :tag
                       :uri]}
   :vimeo.video/type
   :vimeo.video/uri
   :vimeo.video/width
   :vimeo.video.app/name
   :vimeo.video.app/uri
   :vimeo.video.embed/color
   :vimeo.video.embed/html
   :vimeo.video.embed/playbar
   :vimeo.video.embed/speed
   :vimeo.video.embed/uri
   :vimeo.video.embed/volume
   :vimeo.video.embed.badges/hdr
   :vimeo.video.embed.badges/vod
   :vimeo.video.embed.badges/weekend-challenge
   :vimeo.video.embed.badges.live/archived
   :vimeo.video.embed.badges.live/streaming
   :vimeo.video.embed.badges.staff-pick/best-of-the-month
   :vimeo.video.embed.badges.staff-pick/best-of-the-year
   :vimeo.video.embed.badges.staff-pick/normal
   :vimeo.video.embed.badges.staff-pick/premiere
   :vimeo.video.embed.buttons/embed
   :vimeo.video.embed.buttons/fullscreen
   :vimeo.video.embed.buttons/hd
   :vimeo.video.embed.buttons/like
   :vimeo.video.embed.buttons/scaling
   :vimeo.video.embed.buttons/share
   :vimeo.video.embed.buttons/watchlater
   :vimeo.video.embed.logos/vimeo
   :vimeo.video.embed.logos.custom/active
   :vimeo.video.embed.logos.custom/link
   :vimeo.video.embed.logos.custom/sticky
   :vimeo.video.embed.logos.custom/url
   :vimeo.video.embed.title/name
   :vimeo.video.embed.title/owner
   :vimeo.video.embed.title/portrait
   :vimeo.video.metadata.connections/related
   :vimeo.video.metadata.connections.albums/options
   :vimeo.video.metadata.connections.albums/total
   :vimeo.video.metadata.connections.albums/uri
   :vimeo.video.metadata.connections.available-albums/options
   :vimeo.video.metadata.connections.available-albums/total
   :vimeo.video.metadata.connections.available-albums/uri
   :vimeo.video.metadata.connections.comments/options
   :vimeo.video.metadata.connections.comments/total
   :vimeo.video.metadata.connections.comments/uri
   :vimeo.video.metadata.connections.credits/options
   :vimeo.video.metadata.connections.credits/total
   :vimeo.video.metadata.connections.credits/uri
   :vimeo.video.metadata.connections.likes/options
   :vimeo.video.metadata.connections.likes/total
   :vimeo.video.metadata.connections.likes/uri
   :vimeo.video.metadata.connections.pictures/options
   :vimeo.video.metadata.connections.pictures/total
   :vimeo.video.metadata.connections.pictures/uri
   :vimeo.video.metadata.connections.recommendations/options
   :vimeo.video.metadata.connections.recommendations/uri
   :vimeo.video.metadata.connections.texttracks/options
   :vimeo.video.metadata.connections.texttracks/total
   :vimeo.video.metadata.connections.texttracks/uri
   :vimeo.video.metadata.connections.versions/current-uri
   :vimeo.video.metadata.connections.versions/options
   :vimeo.video.metadata.connections.versions/resource-key
   :vimeo.video.metadata.connections.versions/total
   :vimeo.video.metadata.connections.versions/uri
   :vimeo.video.metadata.interactions.edit/options
   :vimeo.video.metadata.interactions.edit/uri
   :vimeo.video.metadata.interactions.like/added
   :vimeo.video.metadata.interactions.like/added-time
   :vimeo.video.metadata.interactions.like/options
   :vimeo.video.metadata.interactions.like/uri
   :vimeo.video.metadata.interactions.report/options
   :vimeo.video.metadata.interactions.report/reason
   :vimeo.video.metadata.interactions.report/uri
   :vimeo.video.metadata.interactions.view-team-members/options
   :vimeo.video.metadata.interactions.view-team-members/uri
   :vimeo.video.metadata.interactions.watchlater/added
   :vimeo.video.metadata.interactions.watchlater/added-time
   :vimeo.video.metadata.interactions.watchlater/options
   :vimeo.video.metadata.interactions.watchlater/uri
   :vimeo.video.pictures/active
   :vimeo.video.pictures/default-picture
   :vimeo.video.pictures/resource-key
   {:vimeo.video.pictures/sizes [:height :link :link_with_play_button :width]}
   :vimeo.video.pictures/type
   :vimeo.video.pictures/uri
   :vimeo.video.privacy/add
   :vimeo.video.privacy/comments
   :vimeo.video.privacy/download
   :vimeo.video.privacy/embed
   :vimeo.video.privacy/view
   :vimeo.video.review-page/active
   :vimeo.video.review-page/link
   :vimeo.video.stats/plays
   :vimeo.video.transcode/status
   :vimeo.video.upload/approach
   :vimeo.video.upload/complete-uri
   :vimeo.video.upload/form
   :vimeo.video.upload/link
   :vimeo.video.upload/redirect-url
   :vimeo.video.upload/size
   :vimeo.video.upload/status
   :vimeo.video.upload/upload-link
   :vimeo.video.user/account
   :vimeo.video.user/available-for-hire
   :vimeo.video.user/bio
   :vimeo.video.user/can-work-remotely
   :vimeo.video.user/created-time
   :vimeo.video.user/gender
   :vimeo.video.user/link
   :vimeo.video.user/location
   :vimeo.video.user/name
   :vimeo.video.user/resource-key
   :vimeo.video.user/short-bio
   :vimeo.video.user/skills
   :vimeo.video.user/uri
   {:vimeo.video.user/websites [:description :link :name :type :uri]}
   :vimeo.video.user.location-details/city
   :vimeo.video.user.location-details/country
   :vimeo.video.user.location-details/country-iso-code
   :vimeo.video.user.location-details/formatted-address
   :vimeo.video.user.location-details/latitude
   :vimeo.video.user.location-details/longitude
   :vimeo.video.user.location-details/neighborhood
   :vimeo.video.user.location-details/state
   :vimeo.video.user.location-details/state-iso-code
   :vimeo.video.user.location-details/sub-locality
   :vimeo.video.user.metadata.connections.albums/options
   :vimeo.video.user.metadata.connections.albums/total
   :vimeo.video.user.metadata.connections.albums/uri
   :vimeo.video.user.metadata.connections.appearances/options
   :vimeo.video.user.metadata.connections.appearances/total
   :vimeo.video.user.metadata.connections.appearances/uri
   :vimeo.video.user.metadata.connections.channels/options
   :vimeo.video.user.metadata.connections.channels/total
   :vimeo.video.user.metadata.connections.channels/uri
   :vimeo.video.user.metadata.connections.feed/options
   :vimeo.video.user.metadata.connections.feed/uri
   :vimeo.video.user.metadata.connections.folders/options
   :vimeo.video.user.metadata.connections.folders/total
   :vimeo.video.user.metadata.connections.folders/uri
   :vimeo.video.user.metadata.connections.folders-root/options
   :vimeo.video.user.metadata.connections.folders-root/uri
   :vimeo.video.user.metadata.connections.followers/options
   :vimeo.video.user.metadata.connections.followers/total
   :vimeo.video.user.metadata.connections.followers/uri
   :vimeo.video.user.metadata.connections.following/options
   :vimeo.video.user.metadata.connections.following/total
   :vimeo.video.user.metadata.connections.following/uri
   :vimeo.video.user.metadata.connections.groups/options
   :vimeo.video.user.metadata.connections.groups/total
   :vimeo.video.user.metadata.connections.groups/uri
   :vimeo.video.user.metadata.connections.likes/options
   :vimeo.video.user.metadata.connections.likes/total
   :vimeo.video.user.metadata.connections.likes/uri
   :vimeo.video.user.metadata.connections.membership/options
   :vimeo.video.user.metadata.connections.membership/uri
   :vimeo.video.user.metadata.connections.moderated-channels/options
   :vimeo.video.user.metadata.connections.moderated-channels/total
   :vimeo.video.user.metadata.connections.moderated-channels/uri
   :vimeo.video.user.metadata.connections.pictures/options
   :vimeo.video.user.metadata.connections.pictures/total
   :vimeo.video.user.metadata.connections.pictures/uri
   :vimeo.video.user.metadata.connections.portfolios/options
   :vimeo.video.user.metadata.connections.portfolios/total
   :vimeo.video.user.metadata.connections.portfolios/uri
   :vimeo.video.user.metadata.connections.shared/options
   :vimeo.video.user.metadata.connections.shared/total
   :vimeo.video.user.metadata.connections.shared/uri
   :vimeo.video.user.metadata.connections.teams/options
   :vimeo.video.user.metadata.connections.teams/total
   :vimeo.video.user.metadata.connections.teams/uri
   :vimeo.video.user.metadata.connections.videos/options
   :vimeo.video.user.metadata.connections.videos/total
   :vimeo.video.user.metadata.connections.videos/uri
   :vimeo.video.user.metadata.interactions.block/added
   :vimeo.video.user.metadata.interactions.block/added-time
   :vimeo.video.user.metadata.interactions.block/options
   :vimeo.video.user.metadata.interactions.block/uri
   :vimeo.video.user.metadata.interactions.follow/added
   :vimeo.video.user.metadata.interactions.follow/added-time
   :vimeo.video.user.metadata.interactions.follow/options
   :vimeo.video.user.metadata.interactions.follow/uri
   :vimeo.video.user.metadata.interactions.report/options
   :vimeo.video.user.metadata.interactions.report/reason
   :vimeo.video.user.metadata.interactions.report/uri
   :vimeo.video.user.pictures/active
   :vimeo.video.user.pictures/default-picture
   :vimeo.video.user.pictures/resource-key
   {:vimeo.video.user.pictures/sizes [:height :link :width]}
   :vimeo.video.user.pictures/type
   :vimeo.video.user.pictures/uri
   :vimeo.video.user.preferences.videos.privacy/add
   :vimeo.video.user.preferences.videos.privacy/comments
   :vimeo.video.user.preferences.videos.privacy/download
   :vimeo.video.user.preferences.videos.privacy/embed
   :vimeo.video.user.preferences.videos.privacy/view])



(def album-list
  [{:vimeo.album-list/data [:vimeo.album/allow-continuous-play
                            :vimeo.album/allow-downloads
                            :vimeo.album/allow-share
                            :vimeo.album/autoplay
                            :vimeo.album/brand-color
                            :vimeo.album/created-time
                            :vimeo.album/custom-logo
                            :vimeo.album/description
                            :vimeo.album/domain
                            :vimeo.album/domain-certificate-state
                            :vimeo.album/duration
                            :vimeo.album/embed-brand-color
                            :vimeo.album/embed-custom-logo
                            :vimeo.album/hide-nav
                            :vimeo.album/hide-upcoming
                            :vimeo.album/hide-vimeo-logo
                            :vimeo.album/layout
                            :vimeo.album/link
                            :vimeo.album/loop
                            :vimeo.album/modified-time
                            :vimeo.album/name
                            :vimeo.album/resource-key
                            :vimeo.album/review-mode
                            :vimeo.album/roku-genres
                            :vimeo.album/roku-language
                            :vimeo.album/roku-provider-name
                            :vimeo.album/seo-allow-indexed
                            :vimeo.album/seo-description
                            :vimeo.album/seo-keywords
                            :vimeo.album/seo-title
                            :vimeo.album/share-link
                            :vimeo.album/sort
                            :vimeo.album/theme
                            :vimeo.album/uri
                            :vimeo.album/url
                            :vimeo.album/use-custom-domain
                            :vimeo.album/user-id
                            :vimeo.album/web-brand-color
                            :vimeo.album/web-custom-logo
                            :vimeo.album.embed/html
                            :vimeo.album.metadata.connections.available-videos/options
                            :vimeo.album.metadata.connections.available-videos/total
                            :vimeo.album.metadata.connections.available-videos/uri
                            :vimeo.album.metadata.connections.videos/options
                            :vimeo.album.metadata.connections.videos/total
                            :vimeo.album.metadata.connections.videos/uri
                            :vimeo.album.metadata.interactions.add-custom-thumbnails/options
                            :vimeo.album.metadata.interactions.add-custom-thumbnails/uri
                            :vimeo.album.metadata.interactions.add-live-events/options
                            :vimeo.album.metadata.interactions.add-live-events/uri
                            :vimeo.album.metadata.interactions.add-logos/options
                            :vimeo.album.metadata.interactions.add-logos/uri
                            :vimeo.album.metadata.interactions.add-videos/options
                            :vimeo.album.metadata.interactions.add-videos/uri
                            :vimeo.album.pictures/active
                            :vimeo.album.pictures/default-picture
                            :vimeo.album.pictures/resource-key
                            {:vimeo.album.pictures/sizes [:height :link :link_with_play_button :width]}
                            :vimeo.album.pictures/type
                            :vimeo.album.pictures/uri
                            :vimeo.album.privacy/view
                            :vimeo.album.user/account
                            :vimeo.album.user/available-for-hire
                            :vimeo.album.user/bio
                            :vimeo.album.user/can-work-remotely
                            :vimeo.album.user/created-time
                            :vimeo.album.user/gender
                            :vimeo.album.user/link
                            :vimeo.album.user/location
                            :vimeo.album.user/name
                            :vimeo.album.user/resource-key
                            :vimeo.album.user/short-bio
                            :vimeo.album.user/skills
                            :vimeo.album.user/uri
                            {:vimeo.album.user/websites [:description :link :name :type :uri]}
                            :vimeo.album.user.location-details/city
                            :vimeo.album.user.location-details/country
                            :vimeo.album.user.location-details/country-iso-code
                            :vimeo.album.user.location-details/formatted-address
                            :vimeo.album.user.location-details/latitude
                            :vimeo.album.user.location-details/longitude
                            :vimeo.album.user.location-details/neighborhood
                            :vimeo.album.user.location-details/state
                            :vimeo.album.user.location-details/state-iso-code
                            :vimeo.album.user.location-details/sub-locality
                            :vimeo.album.user.metadata.connections.albums/options
                            :vimeo.album.user.metadata.connections.albums/total
                            :vimeo.album.user.metadata.connections.albums/uri
                            :vimeo.album.user.metadata.connections.appearances/options
                            :vimeo.album.user.metadata.connections.appearances/total
                            :vimeo.album.user.metadata.connections.appearances/uri
                            :vimeo.album.user.metadata.connections.channels/options
                            :vimeo.album.user.metadata.connections.channels/total
                            :vimeo.album.user.metadata.connections.channels/uri
                            :vimeo.album.user.metadata.connections.feed/options
                            :vimeo.album.user.metadata.connections.feed/uri
                            :vimeo.album.user.metadata.connections.folders/options
                            :vimeo.album.user.metadata.connections.folders/total
                            :vimeo.album.user.metadata.connections.folders/uri
                            :vimeo.album.user.metadata.connections.folders-root/options
                            :vimeo.album.user.metadata.connections.folders-root/uri
                            :vimeo.album.user.metadata.connections.followers/options
                            :vimeo.album.user.metadata.connections.followers/total
                            :vimeo.album.user.metadata.connections.followers/uri
                            :vimeo.album.user.metadata.connections.following/options
                            :vimeo.album.user.metadata.connections.following/total
                            :vimeo.album.user.metadata.connections.following/uri
                            :vimeo.album.user.metadata.connections.groups/options
                            :vimeo.album.user.metadata.connections.groups/total
                            :vimeo.album.user.metadata.connections.groups/uri
                            :vimeo.album.user.metadata.connections.likes/options
                            :vimeo.album.user.metadata.connections.likes/total
                            :vimeo.album.user.metadata.connections.likes/uri
                            :vimeo.album.user.metadata.connections.membership/options
                            :vimeo.album.user.metadata.connections.membership/uri
                            :vimeo.album.user.metadata.connections.moderated-channels/options
                            :vimeo.album.user.metadata.connections.moderated-channels/total
                            :vimeo.album.user.metadata.connections.moderated-channels/uri
                            :vimeo.album.user.metadata.connections.pictures/options
                            :vimeo.album.user.metadata.connections.pictures/total
                            :vimeo.album.user.metadata.connections.pictures/uri
                            :vimeo.album.user.metadata.connections.portfolios/options
                            :vimeo.album.user.metadata.connections.portfolios/total
                            :vimeo.album.user.metadata.connections.portfolios/uri
                            :vimeo.album.user.metadata.connections.shared/options
                            :vimeo.album.user.metadata.connections.shared/total
                            :vimeo.album.user.metadata.connections.shared/uri
                            :vimeo.album.user.metadata.connections.teams/options
                            :vimeo.album.user.metadata.connections.teams/total
                            :vimeo.album.user.metadata.connections.teams/uri
                            :vimeo.album.user.metadata.connections.videos/options
                            :vimeo.album.user.metadata.connections.videos/total
                            :vimeo.album.user.metadata.connections.videos/uri
                            :vimeo.album.user.metadata.interactions.block/added
                            :vimeo.album.user.metadata.interactions.block/added-time
                            :vimeo.album.user.metadata.interactions.block/options
                            :vimeo.album.user.metadata.interactions.block/uri
                            :vimeo.album.user.metadata.interactions.follow/added
                            :vimeo.album.user.metadata.interactions.follow/added-time
                            :vimeo.album.user.metadata.interactions.follow/options
                            :vimeo.album.user.metadata.interactions.follow/uri
                            :vimeo.album.user.metadata.interactions.report/options
                            :vimeo.album.user.metadata.interactions.report/reason
                            :vimeo.album.user.metadata.interactions.report/uri
                            :vimeo.album.user.pictures/active
                            :vimeo.album.user.pictures/default-picture
                            :vimeo.album.user.pictures/resource-key
                            {:vimeo.album.user.pictures/sizes [:height :link :width]}
                            :vimeo.album.user.pictures/type
                            :vimeo.album.user.pictures/uri
                            :vimeo.album.user.preferences.videos.privacy/add
                            :vimeo.album.user.preferences.videos.privacy/comments
                            :vimeo.album.user.preferences.videos.privacy/download
                            :vimeo.album.user.preferences.videos.privacy/embed
                            :vimeo.album.user.preferences.videos.privacy/view
                            :vimeo.album.privacy/password
                            :vimeo.album.custom-logo/active
                            :vimeo.album.custom-logo/default-picture
                            :vimeo.album.custom-logo/resource-key
                            {:vimeo.album.custom-logo/sizes [:height :link :width]}
                            :vimeo.album.custom-logo/type
                            :vimeo.album.custom-logo/uri]}
   :vimeo.album-list/id
   :vimeo.album-list/page
   :vimeo.album-list/per-page
   :vimeo.album-list/total
   :vimeo.album-list.paging/first
   :vimeo.album-list.paging/last
   :vimeo.album-list.paging/next
   :vimeo.album-list.paging/previous])

; what do we do with pagnition data?
;
;    :vimeo.albums/page
;   :vimeo.albums/per-page
;   :vimeo.albums/total
;   :vimeo.albums.paging/first
;   :vimeo.albums.paging/last
;   :vimeo.albums.paging/next
;   :vimeo.albums.paging/previous)


