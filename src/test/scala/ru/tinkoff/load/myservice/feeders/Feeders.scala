package ru.tinkoff.load.myservice.feeders

import ru.tinkoff.gatling.feeders.SequentialFeeder

object Feeders
{
  val idFeed = SequentialFeeder("id", 10000, 1)
}
