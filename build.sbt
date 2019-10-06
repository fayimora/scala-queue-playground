name := "scala-queue-playground"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.clapper" %% "grizzled-slf4j" % "1.3.4",
    "com.github.seratch" %% "awscala" % "0.8.2",
    "com.typesafe.play" %% "play-json" % "2.7.3",
    "com.typesafe.akka" %% "akka-actor" % "2.5.25",
    "com.enragedginger" %% "akka-quartz-scheduler" % "1.8.1-akka-2.5.x"
)
