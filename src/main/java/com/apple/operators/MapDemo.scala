package com.apple.operators

import org.apache.spark.{SparkConf, SparkContext}

object MapDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc: SparkContext = new SparkContext(sparkConf)

//    sc
//      .makeRDD(List(1, 2, 3, 4, 5, 6))
//      .map(r => r + 3)
//      .collect()
//      .foreach(println(_))

    sc
      .makeRDD(List("myj", "lss", "dxy"))
      .map((_, 1))
      .mapValues(r => r + 3)
      .collect()
      .foreach(println(_))

    sc.stop()
  }
}