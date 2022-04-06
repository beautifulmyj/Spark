//package com.apple.sparktuning;object DPPTest {
//
//        case class Student(id: Long, name: String, age: Int, partition: Int)
//
//        case class School(id: Long, name: String, partition: Int)
//
//        def main(args: Array[String]): Unit = {
//                val sparkConf = new SparkConf().setAppName("test")
//                        .set("spark.sql.optimizer.dynamicPartitionPruning.enabled", "true") //关闭dpp
//                val sparkSession = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate()
//                val ssc = sparkSession.sparkContext
//                ssc.hadoopConfiguration.set("fs.defaultFS", "hdfs://mycluster")
//                ssc.hadoopConfiguration.set("dfs.nameservices", "mycluster")
//                getResult(sparkSession)
//                }
//
//        def saveData(sparkSession: SparkSession) = {
//                import sparkSession.implicits._
//                sparkSession.range(1000000).mapPartitions(partitions => {
//                        val random = new Random()
//                        partitions.map(item => Student(item, "name" + item, random.nextInt(100), random.nextInt(100)))
//                        }).write.partitionBy("partition")
//                        .mode(SaveMode.Append)
//                        .saveAsTable("test_student")
//
//                sparkSession.range(1000000).mapPartitions(partitions => {
//                        val random = new Random()
//                        partitions.map(item => School(item, "school" + item, random.nextInt(100)))
//                        }).write.partitionBy("partition")
//                        .mode(SaveMode.Append)
//                        .saveAsTable("test_school")
//                }
//
//        def getResult(sparkSession: SparkSession)={
//                val result=sparkSession.sql("select a.id,a.name,a.age,b.name from default.test_student a inner join default.test_school b  " +
//                        " on a.partition=b.partition and b.id<1000 ")
//                result.foreach(item=>println(item.get(1)))
//                }
//        }
