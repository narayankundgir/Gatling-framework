package simulations.myframework.wb.loadscenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import simulations.myframework.wb.scenarios._
import simulations.myframework.loadscenariosettings.globalsets._
import simulations.myframework.settings.loadscenariosettings._

class Test_Scenario extends Simulation {

  val duration = GlobalSettings.duration
  val rampduration = (i: Int) => { GlobalSettings.rampduration * i }

  val SC01_Login_Only_Loop_ramp = WorkloadModel.SC01_Login_Only_Loop_ramp

  val SC01_Login_Only_Loop_max_qps = WorkloadModel.SC01_Login_Only_Loop_max_qps

  // val SC01_qps = (i: Int) => { WorkloadModel.SC01_Login_Only_Loop_max_qps * i }

  val SC01_max_qps = WorkloadModel.SC01_Login_Only_Loop_max_qps

  val SC01_calc_qps = (i: Int, j: Int) => QPS_Calc.get_qps(i, j)

  setUp(
    //    SC01_Login_Only_Loop.ValSC01_Login_Only_Loop.inject(SC01_Login_Only_Loop_ramp)
    //      .throttle(reachRps(SC01_qps(1)) in (rampduration(1) seconds),
    //        jumpToRps(SC01_qps(2)), holdFor(rampduration(1) seconds),
    //        jumpToRps(SC01_qps(3)), holdFor(rampduration(1) seconds),
    //        jumpToRps(SC01_qps(4)), holdFor(duration seconds)),

    SC01_Login_Only_Loop.ValSC01_Login_Only_Loop.inject(SC01_Login_Only_Loop_ramp)
      .throttle(reachRps(SC01_calc_qps(SC01_max_qps, 4)) in (rampduration(1) seconds),
        jumpToRps(SC01_calc_qps(SC01_max_qps, 3)), holdFor(rampduration(1) seconds),
        jumpToRps(SC01_calc_qps(SC01_max_qps, 2)), holdFor(rampduration(1) seconds),
        jumpToRps(SC01_calc_qps(SC01_max_qps, 1)), holdFor(duration seconds))).protocols(GlobalSettings.http_conf)
}

