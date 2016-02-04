package scalawaw.app

  import akka.actor.ActorRef
  import akka.util.Timeout

  import scala.concurrent.Await
  import scala.concurrent.duration._
import scalawaw.service.com.detector.console.http.service.HttpService

trait ClassifierService extends HttpService {

    import akka.pattern.ask

    implicit val timeout = Timeout(10.seconds)

    lazy val dashboard: ActorRef = system.actorOf(DashboardActor.props(), "dashboard")

    def alarms = path("list") { id =>
      get {
        complete {
          <div><h1>Hello World</h1></div>
        }
      }
    }


