import PlayKeys._

name := "play-web-service"

version := "1.0"

scalaVersion := "2.11.8"

enablePlugins(PlayScala)

devSettings := Seq("play.server.http.port" -> "8000")

libraryDependencies ++= {
  val playVersion = "2.4.0"
    Seq(
      "com.typesafe.play" %% "play" % playVersion,
      "com.typesafe.play" %% "play-docs" % playVersion
    )
}

addCommandAlias("run-actions", "; run -Dhttp.port=8080")
    