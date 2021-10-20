package ru.tinkoff.load.myservice

import io.gatling.core.Predef._
import ru.tinkoff.gatling.amqp.Predef._
import ru.tinkoff.load.jdbc.Predef._
import ru.tinkoff.load.myservice.scenarios.MultiScenario


class MultiProtocol extends Simulation {

  setUp(
    MultiScenario().inject(atOnceUsers(1))
  ).protocols(httpProtocol, amqpConf, jdbcConf)
}
