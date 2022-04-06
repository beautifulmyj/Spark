package com.apple.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object Demo001 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._ // 强制加上，用到时再加可能就晚了

    val schema = new StructType()
      .add("name",StringType,true)
      .add("age",IntegerType,true)
      .add("City",StringType,true)

    val df_with_schema = spark.read.format("csv")
      .option("header", "true")
      .schema(schema)
      .load("datas/girls.txt")

//    df_with_schema.printSchema()
//    df_with_schema.show(false)

    df_with_schema.createOrReplaceTempView("girls_info")

    spark.sql("select name, city from girls_info").show(false)

    spark.stop()
  }
}
