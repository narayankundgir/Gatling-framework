package simulations.myframework.settings.loadscenariosettings

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

object QPS_Calc {

  def get_qps(max_qps: Int, step_num: Int): Int = {
    var result_qps = max_qps
    if (step_num > 1) {
      for (i <- step_num to 2 by -1) { result_qps = (math ceil (result_qps / 2)).intValue() }
      return result_qps
    } else
      return result_qps
  }
}