package ru.tinkoff.load.myservice.cases

import io.gatling.core.Predef._
import ru.tinkoff.load.jdbc.actions
import ru.tinkoff.load.jdbc.Predef._
import ru.tinkoff.load.jdbc.actions.Columns

object JdbcAction {
  def insertTable(tableName: String): actions.DBInsertActionBuilder =
    jdbc("INSERT " + tableName)
      .insertInto(tableName, Columns( "name"))
      .values(
        "name" -> "red"
      )

  def selectTable(tableName: String): actions.QueryActionBuilder = {
    jdbc(s"SELECT $tableName").query(s"SELECT * FROM $tableName").check(allResults.saveAs("RR"))
  }
}
