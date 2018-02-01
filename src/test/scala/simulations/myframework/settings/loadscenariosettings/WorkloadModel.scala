/*
*****************************************************************************
Author   :------------------------------Narayan Kundgir
Version  :------------------------------1.0
Date     :------------------------------28 Nov 2017
*****************************************************************************
Functionality
********************************************************
*/

package simulations.myframework.settings.loadscenariosettings

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import simulations.myframework.wb.scenarios._
import simulations.myframework.wb.modules._
import simulations.myframework.loadscenariosettings.globalsets._

object WorkloadModel {

  //**********************************Input User **********************************
  //RampUp details 
  val _totalusers = GlobalSettings.totalusers //Integer.getInteger("totalusers", 10).toInt
  val _targetqps = GlobalSettings.targetqps //Integer.getInteger("targetqps", 5).toInt
  val _duration = GlobalSettings.duration

  //**********************************RampUp parameters**********************************
  //RampUp details 
  val rampuserspergivensecs = 1
  val steptime = 1
  val rampUserssim = 1

  //**********************************Percent load distribution **********************************
  //Users in Percent
  //Ping
  val _SC01_Login_Only_Loop_percent = 100

  //********************************** Calculated User per scenario **********************************     
  val _SC01_Login_Only_Loop_user = (math ceil (_SC01_Login_Only_Loop_percent * _totalusers / 100)).intValue()

  //**********************************RampUp**********************************
  //rampUp settings
  def SC01_Login_Only_Loop_ramp = splitUsers(_SC01_Login_Only_Loop_user) into (rampUsers(rampUserssim) over (rampuserspergivensecs seconds)) separatedBy (steptime seconds)

  //*************************** Ramp QPS Settings **************************************
  def SC01_Login_Only_Loop_max_qps = (math ceil (_SC01_Login_Only_Loop_percent * _targetqps / 100)).intValue()

  //**********************************RampUp Getters**********************************
  //Getters rampUp settings
  //Ping
  // def SC01_Login_Only_Loop_ramp= _SC01_Login_Only_Loop_ramp

}