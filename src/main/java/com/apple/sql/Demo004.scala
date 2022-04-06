package com.apple.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{ArrayType, DataTypes, IntegerType, MapType, StringType, StructType, TimestampType}

object Demo004 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val schema = new StructType()
      .add("id", StringType, true)
      .add("stt", TimestampType, true)
      .add("edt", TimestampType, true)
    //      .add("", TimestampType, nullable = true)

    val sourceDF = spark.read.format("csv")
      .option("header", "false")
      .schema(schema)
      .load("datas/zhubo")

    sourceDF.createOrReplaceTempView("zhubo")

    //    spark.sql("select id, stt dt, 1 p from zhubo union select id, edt dt, -1 p from zhubo").show()
    //    spark.sql("select t1.id, t1.stt, t1.edt from zhubo t1 semi join (select id from zhubo where id = '1001')t2 on t1.id = t2.id").show()
    //    spark.sql("select id, stt, edt, dense_rank(stt) over(order by stt desc) dk from zhubo").show()
    spark.sql("select id, stt, edt from zhubo sort by stt desc").show()
    spark.stop()
  }
}
