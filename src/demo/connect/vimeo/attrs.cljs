(ns demo.connect.vimeo.attrs)

(def aliases {})

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



(def albums
  [:vimeo.user/id
   {:vimeo.albums/data [:allow_continuous_play
                        :allow_downloads
                        :allow_share
                        :autoplay
                        :brand_color
                        :created_time
                        {:custom_logo [:active :default_picture :resource_key {:sizes [:height :link :width]} :type :uri]}
                        :description
                        :domain
                        :domain_certificate_state
                        :duration
                        {:embed [:html]}
                        :embed_brand_color
                        :embed_custom_logo
                        :hide_nav
                        :hide_upcoming
                        :hide_vimeo_logo
                        :layout
                        :link
                        :loop
                        {:metadata [{:connections [{:available_videos [:options :total :uri]}
                                                   {:videos [:options :total :uri]}]}
                                    {:interactions [{:add_custom_thumbnails [:options :uri]}
                                                    {:add_live_events [:options :uri]}
                                                    {:add_logos [:options :uri]}
                                                    {:add_videos [:options :uri]}]}]}
                        :modified_time
                        :name
                        {:pictures [:active
                                    :default_picture
                                    :resource_key
                                    {:sizes [:height :link :link_with_play_button :width]}
                                    :type
                                    :uri]}
                        {:privacy [:view :password]}
                        :resource_key
                        :review_mode
                        :roku_genres
                        :roku_language
                        :roku_provider_name
                        :seo_allow_indexed
                        :seo_description
                        :seo_keywords
                        :seo_title
                        :share_link
                        :sort
                        :theme
                        :uri
                        :url
                        :use_custom_domain
                        {:user [:account
                                :available_for_hire
                                :bio
                                :can_work_remotely
                                :created_time
                                :gender
                                :link
                                :location
                                {:location_details [:city
                                                    :country
                                                    :country_iso_code
                                                    :formatted_address
                                                    :latitude
                                                    :longitude
                                                    :neighborhood
                                                    :state
                                                    :state_iso_code
                                                    :sub_locality]}
                                {:metadata [{:connections [{:albums [:options :total :uri]}
                                                           {:appearances [:options :total :uri]}
                                                           {:channels [:options :total :uri]}
                                                           {:feed [:options :uri]}
                                                           {:folders [:options :total :uri]}
                                                           {:folders_root [:options :uri]}
                                                           {:followers [:options :total :uri]}
                                                           {:following [:options :total :uri]}
                                                           {:groups [:options :total :uri]}
                                                           {:likes [:options :total :uri]}
                                                           {:membership [:options :uri]}
                                                           {:moderated_channels [:options :total :uri]}
                                                           {:pictures [:options :total :uri]}
                                                           {:portfolios [:options :total :uri]}
                                                           {:shared [:options :total :uri]}
                                                           {:teams [:options :total :uri]}
                                                           {:videos [:options :total :uri]}]}
                                            {:interactions [{:block [:added :added_time :options :uri]}
                                                            {:follow [:added :added_time :options :uri]}
                                                            {:report [:options :reason :uri]}]}]}
                                :name
                                {:pictures [:active
                                            :default_picture
                                            :resource_key
                                            {:sizes [:height :link :width]}
                                            :type
                                            :uri]}
                                {:preferences [{:videos [{:privacy [:add :comments :download :embed :view]}]}]}
                                :resource_key
                                :short_bio
                                :skills
                                :uri
                                {:websites [:description :link :name :type :uri]}]}
                        :web_brand_color
                        :web_custom_logo]}
   :vimeo.albums/page
   :vimeo.albums/per-page
   :vimeo.albums/total
   :vimeo.albums.paging/first
   :vimeo.albums.paging/last
   :vimeo.albums.paging/next
   :vimeo.albums.paging/previous])

