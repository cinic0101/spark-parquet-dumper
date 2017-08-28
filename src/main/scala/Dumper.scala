import java.io.File

import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.{SaveMode, SparkSession}

import scala.collection.JavaConverters._

class Dumper {

  def main(args: Array[String]): Unit = {
    if(args.length == 0) {
      print(Console.RED)
      println("Config path not found.")
      print(Console.RESET)
      return
    }

    val sparkSession = SparkSession.builder
      .appName("spark-parquet-dumper")
      .getOrCreate()

    val config = ConfigFactory.parseFile(new File(args(0)))
    val from = sparkSession.read
      .format("jdbc")
      .option("driver", config.getString("driver"))
      .option("url", config.getString("url"))
      .option("dbtable", config.getString("dbTable"))
      .option("user", config.getString("user"))
      .option("password", config.getString("password"))
      .load()

    val columns = config.getStringList("columns").asScala
    import org.apache.spark.sql.functions._
    from.select(columns.map(col): _*).write.mode(SaveMode.Overwrite).save(config.getString("saveAs"))
  }
}
