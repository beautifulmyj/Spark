package com.apple.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DateType, IntegerType, StringType, StructType, TimestampType}

object Demo007 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val schema = new StructType()
      .add("id",StringType,true)
      .add("dt",DateType,true)

    spark.read.format("csv")
      .option("delimiter", " ")
      .schema(schema)
      .load("datas/logs")
      .createOrReplaceTempView("Logs")

    spark.sql(
      """
        |select
        |  t3.id id,
        |  max(t3.cnt) max_cnt
        |from
        |  (
        |    select
        |      t2.id id,
        |      count(1) cnt
        |    from
        |      (
        |        select
        |          id,
        |          dt,
        |          date_sub(dt, rk) ds
        |        from
        |          (
        |            select
        |              id,
        |              dt,
        |              row_number() over(
        |                partition by id
        |                order by
        |                  dt
        |              ) AS rk
        |            from
        |              Logs
        |          ) t1
        |      ) t2
        |    group by
        |      t2.id,
        |      t2.ds
        |  ) t3
        |group by
        |  t3.id
        |""".stripMargin).show()

    // select t3.id id, max(t3.cnt) max_cnt from (select t2.id id, count(1) cnt from (select id, dt, date_sub(dt, rk) ds from (select id, dt, row_number() over(partition by id order by dt) AS rk from Logs) t1)t2 group by t2.id, t2.ds)t3 group by t3.id

    spark.stop()
  }
}
