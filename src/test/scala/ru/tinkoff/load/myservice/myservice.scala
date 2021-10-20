package ru.tinkoff.load

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import ru.tinkoff.gatling.amqp.Predef._
import ru.tinkoff.gatling.amqp.protocol.AmqpProtocolBuilder
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.load.jdbc.Predef._
import ru.tinkoff.load.jdbc.protocol.JdbcProtocolBuilder

package object myservice {

  //common http protocol params (eg headers, checks)
  val httpProtocol = http
    .baseUrl(baseUrl) // Here is the root for all relative URLs, located in simulation.conf file, or -DbaseUrl="" passed to test param
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    .disableFollowRedirect

  val amqpConf: AmqpProtocolBuilder = amqp
    .connectionFactory(
      rabbitmq
        .host("m1-wof-qaload-rabbit01.tcsbank.ru")
        .port(5672)
        .username("guest")
        .password("guest")
        .vhost("/")
    )
    .usePersistentDeliveryMode
    .declare(queue(name = "MultiTest", autoDelete = false, arguments = Map("x-queue-type" -> "classic")))

  val jdbcConf: JdbcProtocolBuilder = DB
    .url("jdbc:postgresql://localhost:5432/rainbow_database")
    .username("unicorn_user")
    .password("magical_password")

}
