package com.apple.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Demo010 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Apple")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    spark.sparkContext.textFile("datas/text").flatMap(l => l.split(" ")).map((_, 1)).reduceByKey(_+_).map{case (k, v) => (v, k)}.sortByKey(false).take(5).map{case (k, v) => (v, k)}.foreach(println)

    spark.stop()
  }
}
