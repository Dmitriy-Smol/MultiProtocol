package ru.tinkoff.load.myservice.cases

import io.gatling.core.Predef._
import ru.tinkoff.gatling.amqp.Predef.amqp

object AmqpAction {
  val publish = amqp("publish to exchange").publish
    .queueExchange("MultiTest")
    .textMessage("Hello message 1")
    .messageId("${id}")
    .priority(0)
}
