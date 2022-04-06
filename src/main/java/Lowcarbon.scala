import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object Lowcarbon {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    val schema = new StructType()
      .add("id", StringType, false)
      .add("dt", StringType, true)
      .add("carbon", IntegerType, true)

    val sourceDS = spark.read.format("csv").option("delimiter", "\t").schema(schema).load("datas/lowcarbon")

    sourceDS.createOrReplaceTempView("SourceTable")

//    spark.sql("select id from (select id from (select id, dt, carbon, datediff(lag2day,dt) df from (select id, dt, carbon, lead(dt,2,'9999-99-99') over(partition by id order by dt) lag2day from (select id, dt, sum(carbon) carbon from SourceTable group by id, dt having sum(carbon) >= 100) t1)t2)t3 where df = 2)t4 group by id").show()

    spark.sql(
      """
        |select
        |  id
        |from
        |  (
        |    select
        |      id
        |    from
        |      (
        |        select
        |          id,
        |          dt,
        |          carbon,
        |          datediff(lag2day, dt) df
        |        from
        |          (
        |            select
        |              id,
        |              dt,
        |              carbon,
        |              lead(dt, 2, '9999-99-99') over(
        |                partition by id
        |                order by
        |                  dt
        |              ) lag2day
        |            from
        |              (
        |                select
        |                  id,
        |                  dt,
        |                  sum(carbon) carbon
        |                from
        |                  SourceTable
        |                group by
        |                  id,
        |                  dt
        |                having
        |                  sum(carbon) >= 100
        |              ) t1
        |          ) t2
        |      ) t3
        |    where
        |      df = 2
        |  ) t4
        |group by
        |  id""".stripMargin).explain("formatted")
    spark.stop()
  }
}
