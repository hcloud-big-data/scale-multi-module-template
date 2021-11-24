name := "aws-glue-elk"

version := "0.1"

scalaVersion := "3.1.0"

organization := "com.infwaves"

idePackagePrefix := Some("com.infwaves.crawler.elt")

// PROJECTS

lazy val global = project
  .in(file("."))
  .aggregate(
    common,
    etl_crawler,
  )

lazy val common = project.settings(
  name := "common",
  settings,
  libraryDependencies ++= commonDependencies
)

lazy val etl_crawler = project.settings(
  name := "etl_crawler",
  settings,
  libraryDependencies ++= commonDependencies
)
  .dependsOn(
    common
  )

// DEPENDENCI
lazy val dependencies =
  new {
    val logbackV = "1.2.7"
    val logstashV = "7.0.1"
    val scalaLoggingV = "3.9.4"

    val logback = "ch.qos.logback" % "logback-classic" % logbackV
    val logstash = "net.logstash.logback" % "logstash-logback-encoder" % logstashV
    val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingV
  }

lazy val commonDependencies = Seq(
  dependencies.logback,
  dependencies.logstash,
  dependencies.scalaLogging,
)

lazy val settings = commonSettings

lazy val compilerOptions = Seq(
  "-unchecked",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-deprecation",
  "-encoding",
  "utf8"
)

lazy val commonSettings = Seq(
  scalacOptions ++= compilerOptions,
  resolvers ++= Seq(
    "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository",
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )
)
