import sbt._

object Dependencies {
  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling"            % "gatling-test-framework",
  ).map(_ % "3.6.1" % Test)

  lazy val gelf: Seq[ModuleID] = Seq(
    "de.siegmar" % "logback-gelf"
  ).map(_ % "2.1.0")

  lazy val gatlingPicatinny: Seq[ModuleID] = Seq(
    "ru.tinkoff" %% "gatling-picatinny"
  ).map(_ % "0.7.2")

  lazy val janino: Seq[ModuleID] = Seq(
    "org.codehaus.janino" % "janino"
  ).map(_ % "3.1.2")

  lazy val amqp: Seq[ModuleID] = Seq(
    "ru.tinkoff" %% "gatling-amqp-plugin" % "0.5.1" % Test,
  )
  lazy val jdbc: Seq[ModuleID] = Seq(
    "ru.tinkoff" %% "gatling-jdbc-plugin" % "0.4.2" % Test,
  )

  lazy val postgresJdbc: Seq[ModuleID] = Seq(
    "org.postgresql" % "postgresql" % "42.2.23",
  )



}
