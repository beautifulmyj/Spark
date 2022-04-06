package com.apple.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object Demo002 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val schema = new StructType()
      .add("id",StringType,true)
      .add("salary",IntegerType,true)

    val sourceDF = spark.read.format("csv")
      .option("header", "false")
      .schema(schema)
      .load("datas/salaries.txt")

    sourceDF.createOrReplaceTempView("Employee")

//    spark.sql("select max(salary) from Employee where salary < (select max(salary) from Employee)"). explain(mode = "extended")
//    spark.sql("select max(salary) from Employee where salary < (select max(salary) from Employee)").show()
    spark.sql("with emp as (select * from Employee) select e1.id, e1.salary from emp e1 join emp e2 on e1.id = e2.id").show()

    spark.stop()
  }
}
