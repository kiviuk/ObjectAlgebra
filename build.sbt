ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

val catsEffectVersion = "3.6.1"

lazy val root = (project in file("."))
  .settings(
    name := "ObjectAlgebra",
    idePackagePrefix := Some("mobe"),
    libraryDependencies += "org.typelevel" %% "cats-effect" % catsEffectVersion
  )
