package com.apple.sql

import org.apache.spark
import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{ArrayType, DataTypes, MapType, StringType, StructType}

object Demo003 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val arrayStructureData = Seq(
      Row("James", List(Row("Newark", "NY"), Row("Brooklyn", "NY")),
        Map("hair" -> "black", "eye" -> "brown"), Map("height" -> "5.9")),
      Row("Michael", List(Row("SanJose", "CA"), Row("Sandiago", "CA")),
        Map("hair" -> "brown", "eye" -> "black"), Map("height" -> "6")),
      Row("Robert", List(Row("LasVegas", "NV")),
        Map("hair" -> "red", "eye" -> "gray"), Map("height" -> "6.3")),
      Row("Maria", null, Map("hair" -> "blond", "eye" -> "red"),
        Map("height" -> "5.6")),
      Row("Jen", List(Row("LAX", "CA"), Row("Orange", "CA")),
        Map("white" -> "black", "eye" -> "black"), Map("height" -> "5.2"))
    )

    val mapType = DataTypes.createMapType(StringType, StringType)

    val arrayStructureSchema = new StructType()
      .add("name", StringType)
      .add("addresses", ArrayType(new StructType()
        .add("city", StringType)
        .add("state", StringType)))
      .add("properties", mapType)
      .add("secondProp", MapType(StringType, StringType))

    val mapTypeDF = spark.createDataFrame(
      spark.sparkContext.parallelize(arrayStructureData), arrayStructureSchema)
    mapTypeDF.printSchema()
    mapTypeDF.show()
    spark.stop()
  }
}
