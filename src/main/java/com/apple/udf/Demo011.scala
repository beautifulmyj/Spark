package com.apple.udf

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, udf}
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object Demo011 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()

    val schema = new StructType()
      .add("name", StringType, true)
      .add("age", IntegerType, true)
      .add("city", StringType, true)

    val sourceDF = spark.read.format("csv").option("header", "false").schema(schema).load("datas/girls.txt")

    sourceDF.createOrReplaceTempView("Girls")

    // use in sql
    spark.udf.register("convertUDF", convertCase)
    spark.sql("select name, convertUDF(age) new_age, city from Girls").show()

    // use in table api
    val convertUDF = udf(convertCase)
    sourceDF.select(col("name"), convertUDF(col("age")).as("new_age") ).show(false)

    spark.stop()
  }

  val convertCase = (age: Int) => {
    age + 100
  }
}
