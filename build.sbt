enablePlugins(JavaAppPackaging)

name := "microservice-classifier"

version := "1.0"

scalaVersion := "2.11.7"

import _root_.sbt._

val scalaV = "2.11.7"

val commonSettings = Seq(
  organization := "TODO",
  version := "1.0",
  scalaVersion := scalaV,
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8"),
  resolvers ++= Seq(
    "Local Maven Repository" at s"file://${Path.userHome.absolutePath}/.m2/repository"
  )
)

val akkaV = "2.4.1"
val akkaStreamV = "2.0-M2"
val scalaTestV = "2.2.5"
val scalaLoggingV = "3.1.0"
val logbackV = "1.1.3"


    libraryDependencies ++= {
      Seq(
        "com.typesafe.akka"  %% "akka-actor" % akkaV,
        "com.typesafe.akka"  %% "akka-stream-experimental" % akkaStreamV,
        "com.typesafe.akka"  %% "akka-stream-testkit-experimental" % akkaStreamV,
        "com.typesafe.akka"  %% "akka-http-core-experimental" % akkaStreamV,
        "com.typesafe.akka"  %% "akka-http-experimental" % akkaStreamV,
        "com.typesafe.akka"  %% "akka-testkit" % akkaV,
        "com.typesafe.akka"  %% "akka-http-spray-json-experimental" % akkaStreamV,
        "com.typesafe.akka"  %% "akka-http-xml-experimental" % akkaStreamV,
        "com.typesafe.akka"  %% "akka-http-testkit-experimental" % akkaStreamV,
        "com.typesafe.akka"  %% "akka-slf4j" % akkaV,
        "ch.qos.logback"     % "logback-classic" % logbackV,
        "org.scalatest"      %% "scalatest" % scalaTestV % "test"
      )
    }
