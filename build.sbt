import sbtghpackages.TokenSource.Environment

ThisBuild / scalaVersion := "2.12.10"
ThisBuild / version := "0.4.7"
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
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.1.1",
      "org.typelevel" %% "cats-effect" % "2.1.2",
      "org.scalatest" %% "scalatest" % "3.1.1" % Test
    )
  )
