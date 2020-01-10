import sbtghpackages.TokenSource.Environment

ThisBuild / scalaVersion := "2.12.10"
ThisBuild / version := "0.3.2"
ThisBuild / organization := "lambda"
ThisBuild / organizationName := "Lambdacademy"

ThisBuild / githubUser := sys.env.getOrElse("GITHUB_USER", "REPLACE_ME")
ThisBuild / githubOwner := "lambdacademy-dev"
ThisBuild / githubTokenSource := Some(Environment("GITHUB_TOKEN"))
ThisBuild / githubRepository := "domain"

lazy val root = (project in file("."))
  .settings(
    name := "domain",
    githubOwner := "lambdacademy-dev",
    resolvers += Resolver.bintrayRepo("colisweb", "maven"),
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.0.0",
      "com.colisweb" %% "scala-opentracing" % "0.1.0",
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    )
  )
