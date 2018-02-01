package simulations.myframework.wb.loadscenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import simulations.myframework.wb.scenarios._
import simulations.myframework.loadscenariosettings.globalsets._

class Jpet_Scenario extends Simulation {
   
// ******************* User Count allocation start here *********************************//
 val user_count = 1
 
 //  ******************* User Count allocation End here *********************************//
    
 val SC01_Login_Only_RAMP = atOnceUsers(user_count)
 
  // Setup the scenario.
 setUp(
     SC01_Login_Only.ValSC01_Login_Only.inject(SC01_Login_Only_RAMP)
     ).protocols(GlobalSettings.http_conf)

}

