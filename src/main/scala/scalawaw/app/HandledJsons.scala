package scalawaw.app

object HandledJsons {

  case class FBLocation(city: Option[String],
                         country: Option[String],
                         latitude: Option[Double],
                         longitude: Option[Double],
                         street: Option[String])

  case class FBPlace(name: Option[String],
                      location: Option[FBLocation],
                      id: Option[String])

  case class FBEvent(description: Option[String],
                      name: Option[String],
                      place: Option[FBPlace],
                      start_time: Option[String],
                      id: Option[String])

  case class MeetupGroup(join_mode: Option[String],
                          created: Option[Double],
                          name: Option[String],
                          group_lon: Option[Double],
                          id: Option[Double],
                          urlname: Option[String],
                          group_lat: Option[Double],
                          who: Option[String])

  case class MeetupEvent(utc_offset: Option[Double],
                         headcount: Option[Double],
                         distance: Option[Double],
                         visibility: Option[String],
                         waitlist_count: Option[Double],
                         created: Option[Double],
                         maybe_rsvp_count: Option[Double],
                         description: Option[String],
                         event_url: Option[String],
                         yes_rsvp_count: Option[Double],
                         duration: Option[Double],
                         name: Option[String],
                         id: Option[String],
                         time: Option[Double],
                         updated: Option[Double],
                         group: Option[MeetupGroup],
                         status: Option[String])

  case class Topics(urlkey: Option[String],
                    name: Option[String],
                    id: Option[Double])

  case class Photo(highres_link: Option[String],
                   photo_id: Option[Double],
                   photo_link: Option[String],
                   thumb_link: Option[String])

  case class OtherServices()

  case class Self(common: Option[OtherServices])

  case class MeetupProfile(country: Option[String],
                           city: Option[String],
                           topics: Option[List[Topics]],
                           joined: Option[Double],
                           link: Option[String],
                           bio: Option[String],
                           photo: Option[Photo],
                           lon: Option[Double],
                           other_services: Option[OtherServices],
                           name: Option[String],
                           visited: Option[Double],
                           self: Option[Self],
                           id: Option[Double],
                           lang: Option[String],
                           lat: Option[Double],
                           status: Option[String])

}
