//package com.apple.sparktuning;object OFFHeapCache {
//
//        def main(args: Array[String]): Unit = {
//                System.setProperty("HADOOP_USER_NAME", "root")
//                val sparkConf = new SparkConf().setAppName("test")
//                val sparkSession = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate()
//                val ssc = sparkSession.sparkContext
//                ssc.hadoopConfiguration.set("fs.defaultFS", "hdfs://mycluster")
//                ssc.hadoopConfiguration.set("dfs.nameservices", "mycluster")
//                useOFFHeapMemory(sparkSession)
//                }
//
//        def useOFFHeapMemory(sparkSession: SparkSession): Unit = {
//                import sparkSession.implicits._
//                val result = sparkSession.sql("select * from dwd.dwd_course_pay ").as[CoursePay]
//                result.persist(StorageLevel.OFF_HEAP)
//                result.foreachPartition((p: Iterator[CoursePay]) => p.foreach(item => println(item.orderid)))
//                while (true) {
//
//                        }
//                }
//        }
