package scalawaw.app

import akka.util.Timeout

import scala.concurrent.duration._
import scalawaw.service.com.detector.console.http.service.HttpService

trait ClassifierService extends HttpService {

  implicit val timeout = Timeout(10.seconds)

  def alarms = path("list") {
    get {
      complete {
        <div>
          <h1>Hello World</h1>
        </div>
      }
    }
  }
}

