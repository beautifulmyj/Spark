//package com.apple.sparktuning;object MemoryTuning {
//
//
//        def main(args: Array[String]): Unit = {
//                System.setProperty("HADOOP_USER_NAME", "root")
//                val sparkConf = new SparkConf().setAppName("test")
//                //      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
//                        //      .registerKryoClasses(Array(classOf[CoursePay]))
//                        val sparkSession = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate()
//                val ssc = sparkSession.sparkContext
//                ssc.hadoopConfiguration.set("fs.defaultFS", "hdfs://mycluster")
//                ssc.hadoopConfiguration.set("dfs.nameservices", "mycluster")
//                //    useRddCache(sparkSession)
//                //    useRddKryo(sparkSession)
//                userDataSet(sparkSession)
//                }
//
//
//        case class CoursePay(orderid: String, discount: BigDecimal, paymoney: BigDecimal, createtime: Timestamp, dt: String, dn: String)
//
//        def useRddCache(sparkSession: SparkSession): Unit = {
//                val result = sparkSession.sql("select * from dwd.dwd_course_pay ").rdd
//                result.persist()
//                result.foreachPartition((p: Iterator[Row]) => p.foreach(item => println(item.get(0))))
//                while (true) {
//                        //因为历史服务器上看不到，storage内存占用，所以这里加个死循环 不让sparkcontext立马结束
//                        }
//                }
//
//        def useRddKryo(sparkSession: SparkSession): Unit = {
//                import sparkSession.implicits._
//                val result = sparkSession.sql("select * from dwd.dwd_course_pay ").as[CoursePay].rdd
//                result.persist(StorageLevel.MEMORY_ONLY_SER)
//                result.foreachPartition((p: Iterator[CoursePay]) => p.foreach(item => println(item.orderid)))
//                while (true) {
//                        //因为历史服务器上看不到，storage内存占用，所以这里加个死循环 不让sparkcontext立马结束
//                        }
//                }
//
//        def userDataSet(sparkSession: SparkSession): Unit = {
//                import sparkSession.implicits._
//                val result = sparkSession.sql("select * from dwd.dwd_course_pay ").as[CoursePay]
//                result.persist(StorageLevel.MEMORY_AND_DISK_SER)
//                result.foreachPartition((p: Iterator[CoursePay]) => p.foreach(item => println(item.orderid)))
//                while (true) {
//                        }
//                }
//
//        }
