
import java.io.File

import com.sensor.SensorStaticSparkImpl
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class SenSorStaticsTestCases extends FunSuite {

  val sensorStstic = new SensorStaticSparkImpl()
  var dir = "D:\\statistics-sensor\\src\\ReportDirectory"
  var fileList: List[File] = null

  test("Test No Processed CSV file") {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      fileList = d.listFiles.filter(_.isFile).toList
      //println(fileList)
    } else {
      List[File]()
    }
    val noOfProFiles=sensorStstic.numOfProcessedFiles(dir)
    noOfProFiles shouldBe fileList.length

  }

  test("Test No Processed Measuments") {
    val mockSensorList=List("s1","s2","s1","s1","s3","s2","s2","s3","s2","s1")
    var filesize = sensorStstic.numOfProcessedFiles(dir)
    val numOfProcMeasurements=sensorStstic.numOfProcessedMeasurements
    numOfProcMeasurements shouldBe mockSensorList.size
  }

  test("Test No Processed Failed") {
    val mockDataForFailedMeasurements= 2
    var filesize = sensorStstic.numOfProcessedFiles(dir)
    val numOfProcMeasurements=sensorStstic.numOfProcessedMeasurements
    val numOfFailedMeasure=sensorStstic.numOfFailedMeasurements
    numOfFailedMeasure shouldBe 2
  }

}