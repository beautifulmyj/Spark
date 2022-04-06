package com.apple.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, lit}
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object Demo009 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Apple")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val schema = new StructType()
      .add("uid", StringType, true)
      .add("subject_id", StringType, true)
      .add("score", IntegerType, true)

    val sourceDF = spark
      .read
      .option("delimiter", "\t")
      .format("csv")
      .schema(schema)
      .load("datas/scores")

//    sourceDF.select($"score" + 100).show()
//    sourceDF.select("subject_id", "score").show()
//    sourceDF.select("*").show()
//    val result = sourceDF.withColumn("new", lit("Apple"))
    val result = sourceDF.withColumn("ano_score", col("score") * 100)
//    val result = sourceDF.select(col("subject_id").alias("sub"), col("score"))
//    result.show(1)

    result.explain("formatted")

    spark.stop()
  }
}
