import com.peknight.build.gav
import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val catsParse = (project in file("."))
  .settings(name := "cats-parse")
  .aggregate(catsParseCore.projectRefs *)

lazy val catsParseCore = (projectMatrix in file("cats-parse-core"))
  .settings(name := "cats-parse-core")
  .settings(libraryDependencies ++= dependencies(typelevel.catsParse))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
