package com.apple.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructType, TimestampType}

object Demo006 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val schema = new StructType()
      .add("uid",StringType,true)
      .add("subject_id",StringType,true)
      .add("score",IntegerType,true)

    val sourceDF = spark.read.format("csv").option("delimiter", "\t").schema(schema).load("datas/scores")

//    sourceDF.createOrReplaceTempView("score")

//    spark.sql("select sid, course, score, sum(flag) flag_sum from (select *, if(score >= avg_score,0,1) flag from (select *, avg(score) over(partition by course) avg_score from Scores)t1)t2 group by sid, course, score having flag_sum = 0").show()
//    spark.sql(
//      """
//        |select
//        |    uid
//        |from
//        |    (select
//        |    uid,
//        |    if(score>avg_score,0,1) flag
//        |from
//        |    (select
//        |    uid,
//        |    score,
//        |    avg(score) over(partition by subject_id) avg_score
//        |from
//        |    score)t1)t2
//        |group by
//        |    uid
//        |having
//        |    sum(flag)=0;
//        |""".stripMargin).show()

//    spark.sql("select uid, sum(score) from score group by uid").take(1)

    // http://localhost:4040
    println(sourceDF.cache().count())
    val plan = sourceDF.queryExecution.logical
    val estimated: BigInt = spark
      .sessionState
      .executePlan(plan)
      .optimizedPlan
      .stats
      .sizeInBytes
    println(estimated)
    while (true) {

    }

    spark.stop()
  }
}
