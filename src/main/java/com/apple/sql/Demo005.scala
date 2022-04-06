package com.apple.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructType, TimestampType}

object Demo005 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val schema = new StructType()
      .add("id",StringType,true)
      .add("num",IntegerType,true)

    val sourceDF = spark.read.format("csv")
      .option("header", "false")
      .schema(schema)
      .load("datas/nums")

    sourceDF.createOrReplaceTempView("Nums")

//    spark.sql("select n1.num from Nums n1, Nums n2, Nums n3 where n1.id = n2.id - 1 and n1.id = n3.id - 2 and n1.num = n2.num and n1.num = n3.num").explain(mode = "extended")
    spark.sql("select * from (select *, array(1,2,3) arr from Nums) lateral view explode(arr) tmp as ctl").show()
    spark.sql("select * from (select *, array(1,2,3) arr from Nums) lateral view explode(arr) tmp as ctl").show()
    spark.sql("select * from (select *, array(1,2,3) arr from Nums) lateral view explode(arr) tmp as ctl").show()
    while (true) {

    }
    spark.stop()
  }
}