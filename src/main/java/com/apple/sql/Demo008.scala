package com.apple.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Demo008 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Apple")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val columns = Seq("language", "users_count")
//    val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
//    val data = Seq(("Java", 1), ("Python", 2), ("Scala", 3))
    val data = Seq(("Java", List(1,2,3)), ("Python", List(1,2,3)), ("Scala", List(1,2,3)))

    val sourceRDD = spark.sparkContext.makeRDD(data)

    sourceRDD.toDF("language", "users_count").printSchema()

    spark.stop()
  }
}
