package scalawaw.app

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.util.Timeout
import spray.json.DefaultJsonProtocol

import scala.concurrent.duration._
import scalawaw.app.HandledJsons.{MeetupEvent, FBEvent}
import scalawaw.service.com.detector.console.http.service.HttpService

trait JsonProtocol extends DefaultJsonProtocol {
  import HandledJsons._

  implicit val fbLocationFormat = jsonFormat5(FBLocation)
  implicit val fbPlaceFormat = jsonFormat3(FBPlace)
  implicit val fbEventFormat = jsonFormat5(FBEvent)

  implicit val meetupGroupFormat = jsonFormat8(MeetupGroup)
  implicit val meetupResultsFormat = jsonFormat17(MeetupEvent)

  implicit val requestFormat = jsonFormat4(ClassificationRequest)
}

case class ClassificationRequest(fbProfile: String, meetupProfile: String,
                                 fbEvents: Seq[FBEvent], meetupEvents: Seq[MeetupEvent])

trait ClassifierService extends HttpService with JsonProtocol with SprayJsonSupport {

  implicit val timeout = Timeout(10.seconds)

  def routes = path("recommendation") {
    (post & entity(as[ClassificationRequest])) { request =>
      complete {
        request.toString
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

