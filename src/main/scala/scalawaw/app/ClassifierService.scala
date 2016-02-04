package scalawaw.app

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.util.Timeout
import spray.json.DefaultJsonProtocol

import scala.concurrent.duration._
import scalawaw.service.com.detector.console.http.service.HttpService

case class ClassificationRequest(fb_profile: String,
                                 meetup_profile: String,
                                 fb_events: String,
                                 meetup_events: String)

trait JsonProtocol extends DefaultJsonProtocol {
  implicit val format = jsonFormat4(ClassificationRequest)
}

trait ClassifierService extends HttpService with JsonProtocol with SprayJsonSupport {

  implicit val timeout = Timeout(10.seconds)

  def alarms = path("recommendation") {
    (get & entity(as[ClassificationRequest])) { request =>
      complete {
        request.toString
      }
    }
  }
}

