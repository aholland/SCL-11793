enablePlugins(ScalaJSPlugin)

resolvers += Resolver.file("releases", file("C:/Workspace/Data/.m2/repository"))

name := "SCL-11793"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
 "com.lihaoyi" %%% "scalatags" % "0.6.3",
 "com.typesafe.slick" %% "slick" % "3.2.0",
 "org.scala-js" %%% "scalajs-dom" % "0.9.1",
 "be.doeraene" %%% "scalajs-jquery" % "0.9.1",
 "org.scala-js" %%% "scalajs-java-time" % "0.2.0"
)

jsDependencies += RuntimeDOM


scalaJSUseMainModuleInitializer := true
mainClass in Compile := Some("vintur.Main")
