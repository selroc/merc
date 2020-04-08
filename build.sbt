
enablePlugins(Antlr4Plugin)

ThisBuild / organization  := "edu.vtc"
ThisBuild / version       := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion  := "2.12.8"
ThisBuild / scalacOptions :=
  Seq("-encoding", "UTF-8",
      "-feature",
      "-deprecation",
      "-unchecked",
      "-Ywarn-adapted-args",
      "-Ywarn-dead-code",
      "-Ywarn-infer-any",
      "-Ywarn-unused-import",
      "-Ywarn-value-discard")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

logBuffered in Test := false

lazy val merc = (project in file("."))
  .settings(
    name := "Merc",

    antlr4Version     in Antlr4 := "4.7.2",
    antlr4PackageName in Antlr4 := Some("edu.vtc.merc"),
    antlr4GenListener in Antlr4 := true,
    antlr4GenVisitor  in Antlr4 := true
  )
