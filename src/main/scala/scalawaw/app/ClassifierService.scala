package scalawaw.app

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.util.Timeout
import spray.json.DefaultJsonProtocol


import scala.concurrent.duration._
import scalawaw.app.HandledJsons.{MeetupProfile, MeetupEvent, FBEvent}
import scalawaw.service.com.detector.console.http.service.HttpService

trait JsonProtocol extends DefaultJsonProtocol {
  import HandledJsons._

  implicit val fbLocationFormat = jsonFormat5(FBLocation)
  implicit val fbPlaceFormat = jsonFormat3(FBPlace)
  implicit val fbEventFormat = jsonFormat5(FBEvent)

  implicit val meetupGroupFormat = jsonFormat8(MeetupGroup)
  implicit val meetupResultsFormat = jsonFormat17(MeetupEvent)

  implicit val topicsFormat =jsonFormat3(Topics)
  implicit val photoFormat = jsonFormat4(Photo)
  implicit val otherFormat = jsonFormat0(OtherServices)
  implicit val selfFormat = jsonFormat1(Self)
  implicit val meetupProfileFormat = jsonFormat16(MeetupProfile)

  implicit val requestFormat = jsonFormat6(ClassificationRequest)
  implicit val responseFormat = jsonFormat2(ClassificationResponse)
}

case class ClassificationRequest(fbProfile: String, meetupProfile: Option[MeetupProfile],
                                 fbEvents: Option[Seq[FBEvent]], meetupEvents: Option[Seq[MeetupEvent]],
                                 fromDate: Option[Long], toDate: Option[Long])

case class ClassificationResponse(fbEvents: Option[Seq[FBEvent]], meetupEvents: Option[Seq[MeetupEvent]])

trait ClassifierService extends HttpService with JsonProtocol with SprayJsonSupport {

  implicit val timeout = Timeout(10.seconds)

  def routes = path("recommendation") {
    (post & entity(as[ClassificationRequest])) { request =>
      complete {
        ClassificationResponse(request.fbEvents, request.meetupEvents)
      }
    }
  } ~ path("test") {
    get {
      complete {
        "OK"
      }
    }
  }
}

