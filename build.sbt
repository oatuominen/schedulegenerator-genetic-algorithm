import Dependencies._

ThisBuild / scalaVersion     := "3.3.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "GeneticAlgorithm",
    Compile / packageBin / mainClass := Some("geneticalgorithm.Main"),
    Compile / run / mainClass := Some("geneticalgorithm.Main"),
    libraryDependencies += munit % Test,
    libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0",
    libraryDependencies += "org.scalanlp" %% "breeze" % "2.1.0",
    libraryDependencies += "org.scalanlp" %% "breeze-viz" % "2.1.0"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
