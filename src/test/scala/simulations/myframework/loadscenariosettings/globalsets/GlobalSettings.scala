package simulations.myframework.loadscenariosettings.globalsets

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import scala.io.Source.fromFile
import java.io.File

object GlobalSettings {

  //-------------------Stop GLobal Variable-------------------- 
  private val _globaluri = System.getProperty("globaluri")
  //-------------------Stop GLobal Variable-------------------- 

  //-------------------start GLobal Setup------------------- 
  val _rampduration = Integer.getInteger("rampduration", 30).toLong
  val _nclients = Integer.getInteger("nclients", 1).toLong
  val _duration = Integer.getInteger("duration", 120).toLong
  var _totalusers = Integer.getInteger("totalusers", 10).toLong
  var _targetqps = Integer.getInteger("targetqps", 5).toLong

  private val _httpConf = http.baseURLs(_globaluri)
  //-------------------Stop GLobal setup--------------------

  //-------------------start GLobal Getters------------------- 
  def http_conf = _httpConf
  def nclients = _nclients
  def rampduration = _rampduration
  def duration = _duration

  if (nclients > 1) {
    _targetqps = _targetqps / _nclients
    _totalusers = _totalusers / _nclients
  }

  def targetqps = _targetqps
  def totalusers = _totalusers
  //-------------------Stop GLobal Getters--------------------  
}