package scalawaw.app

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory


object ClassifierApp {

  def main(args: Array[String]): Unit = new ClassifierService {

    override implicit val system = ActorSystem("detector-console")
    override implicit val materializer: ActorMaterializer = ActorMaterializer()
    override val logger= Logging(system, getClass)

    val config = ConfigFactory.load()

    // start the http server:
    val bindingFuture = Http().bindAndHandle(routes, config.getString("http.host"), config.getInt("http.port"))

  }

}
