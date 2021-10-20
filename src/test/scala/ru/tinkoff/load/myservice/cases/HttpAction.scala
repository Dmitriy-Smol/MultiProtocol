package ru.tinkoff.load.myservice.cases

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object HttpAction {

  val getMainPage = http("GET")
    .get("/get")
    .header("accept","application/json")
    .check(bodyString.saveAs("Response"))
    .check(status is 200)

}
