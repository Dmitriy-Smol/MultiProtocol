package ru.tinkoff.load.myservice.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import ru.tinkoff.load.myservice.cases._
import ru.tinkoff.load.myservice.feeders.Feeders.idFeed
import ru.tinkoff.gatling.amqp.Predef._

object MultiScenario {
  def apply(): ScenarioBuilder = new MultiScenario().scn
}

class MultiScenario {
  val tableName = "color_table"
  val scn: ScenarioBuilder = scenario("Multitest").repeat(1) {
    feed(idFeed)
    .exec(AmqpAction.publish)
    .exec(JdbcAction.selectTable(tableName))
    .exec(HttpAction.getMainPage)
    .exec(session => {
        session
    })
  }
}
