package simulations.myframework.wb.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import simulations.myframework.wb.modules._

/**
 * This Scenario class used to run the view organization flows.
 */
object SC01_Login_Only {
  
  /**
   * The function execute the view organization flows
   * <BR>
   */
  val ValSC01_Login_Only = scenario("SC01_Jpet_Login_Logout")

    // Page 01      
    .exec(Jpet_Login_Page.module_Jpet_Login_Page("SC01_PV01_Login_Page"))

}