package simulations.myframework.wb.modules

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

object Jpet_Login_Page {

  def module_Jpet_Login_Page(transaction: String) =
    {

      exec(http(transaction)
        .get("/jpetstore/shop/index.shtml")
        .check(status.is(200)))

      // .pause(5)
    }
}