
enablePlugins(Antlr4Plugin)

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / organization := "edu.vtc"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

logBuffered in Test := false

lazy val augusta = (project in file("."))
  .settings(
    name := "Merc",

    antlr4Version     in Antlr4 := "4.7.2",
    antlr4PackageName in Antlr4 := Some("edu.vtc.merc"),
    antlr4GenListener in Antlr4 := true,
    antlr4GenVisitor  in Antlr4 := true
  )
