package com.sensor

trait SensorStatic {

  def numOfProcessedFiles(dir: String): Int

  def numOfProcessedMeasurements(): Int

  def numOfFailedMeasurements():Int

  def minAvgMaxHumidity(): Unit

  def sortsSensorsByHighestAvgHumidity():Unit

}
