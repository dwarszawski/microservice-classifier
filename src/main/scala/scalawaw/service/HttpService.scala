package scalawaw.service

package com.detector.console.http.service

import akka.actor.ActorSystem
import akka.event.LoggingAdapter
import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport
import akka.http.scaladsl.server.Directives
import akka.stream.ActorMaterializer

trait HttpService extends Directives with ScalaXmlSupport {
  implicit def system: ActorSystem

  implicit def materializer: ActorMaterializer

  def logger: LoggingAdapter

}


