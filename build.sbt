
import Dependencies.Runtime

// This an example of a simple project definition.
// It should build on both sbt 0.13.15 and sbt 1.0.0
lazy val root = (project in file("."))
  .settings(
    organization in ThisBuild := "com.github.MercurieVV",
    scalaVersion in ThisBuild := "2.12.2",
    version      in ThisBuild := "0.2.7",
    name := "narcolepsy_scala",

    libraryDependencies ++= Seq(
      Runtime.httpCore,
      Runtime.httpClient,
      Runtime.jackCore,
      Runtime.jackMapper,
      Runtime.jackXc,
      Runtime.moxy
    )
  )

/*
name := "prestashop_scalaxb"

version := "0.2.6"

scalaVersion := "2.12.4"*/
