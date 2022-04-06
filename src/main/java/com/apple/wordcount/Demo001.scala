package com.apple.wordcount

import org.apache.spark.{SparkConf, SparkContext}

object Demo001 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc: SparkContext = new SparkContext(sparkConf)

    // 最简单的word count
    sc
      .textFile("datas/names.txt")
      .flatMap(_.split(" "))
      .map((_,1))
      .reduceByKey(_+_)
      .foreach(println(_))

    sc.stop()
  }
}
