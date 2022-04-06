package com.apple

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, LongType, StringType, StructType}

object Visits {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val schema = new StructType()
      .add("id", StringType, false)
      .add("dt", LongType, true)

    val sourceDS = spark.read.format("csv").option("delimiter", "\t").schema(schema).load("datas/visits")

    sourceDS.createOrReplaceTempView("SourceTable")

    spark.sql("select id, dt, sum(dif) over(partition by id order by dt) from (select id, dt, if(next_dt-dt<=60,1,0) dif from (select id, dt, lead(dt,1,0L) over(partition by id order by dt) next_dt from SourceTable))").show()

    spark.stop()
  }
}
