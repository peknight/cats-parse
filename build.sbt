import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val catsParse = (project in file("."))
  .settings(name := "cats-parse")
  .aggregate(
    catsParseCore.jvm,
    catsParseCore.js,
  )

lazy val catsParseCore = (crossProject(JVMPlatform, JSPlatform) in file("cats-parse-core"))
  .settings(name := "cats-parse-core")
  .settings(crossDependencies(typelevel.catsParse))

