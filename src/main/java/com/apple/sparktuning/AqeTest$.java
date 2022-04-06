//package com.apple.sparktuning;object AqeTest {
//        def main(args: Array[String]): Unit = {
//                System.setProperty("HADOOP_USER_NAME", "root")
//                val sparkConf = new SparkConf().setAppName("test")
//                        .set("spark.sql.autoBroadcastJoinThreshold", "-1")
//                        .set("spark.sql.adaptive.enabled","true")
//                        .set("spark.sql.adaptive.coalescePartitions.enabled","true")
//                        .set("spark.sql.adaptive.skewJoin.skewedPartitionFactor","2")
//                        .set("spark.sql.adaptive.skewJoin.skewedPartitionThresholdInBytes","10mb")
//                        .set("spark.sql.adaptive.advisoryPartitionSizeInBytes","8mb")
//                val sparkSession = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate()
//                val ssc = sparkSession.sparkContext
//                ssc.hadoopConfiguration.set("fs.defaultFS", "hdfs://mycluster")
//                ssc.hadoopConfiguration.set("dfs.nameservices", "mycluster")
//                useJoin(sparkSession)
//                }
//
//        def useJoin(sparkSession: SparkSession) = {
//                val saleCourse = sparkSession.sql("select *from dwd.dwd_sale_course")
//                val coursePay = sparkSession.sql("select * from dwd.dwd_course_pay")
//                        .withColumnRenamed("discount", "pay_discount")
//                        .withColumnRenamed("createtime", "pay_createtime")
//                val courseShoppingCart = sparkSession.sql("select *from dwd.dwd_course_shopping_cart")
//                        .drop("coursename")
//                        .withColumnRenamed("discount", "cart_discount")
//                        .withColumnRenamed("createtime", "cart_createtime")
//                saleCourse.join(courseShoppingCart, Seq("courseid", "dt", "dn"), "right")
//                        .join(coursePay, Seq("orderid", "dt", "dn"), "left")
//                        .select("courseid", "coursename", "status", "pointlistid", "majorid", "chapterid", "chaptername", "edusubjectid"
//                        , "edusubjectname", "teacherid", "teachername", "coursemanager", "money", "orderid", "cart_discount", "sellmoney",
//                        "cart_createtime", "pay_discount", "paymoney", "pay_createtime", "dt", "dn")
//                        .write.mode(SaveMode.Overwrite).insertInto("dws.dws_salecourse_detail_1")
//                }
//
//        def switchJoinStartegies(sparkSession: SparkSession) = {
//                //    val saleCourse = sparkSession.sql("select *from dwd.dwd_sale_course")
//                        val coursePay = sparkSession.sql("select * from dwd.dwd_course_pay")
//                        .withColumnRenamed("discount", "pay_discount")
//                        .withColumnRenamed("createtime", "pay_createtime")
//                        .where("orderid between 'odid-9999000' and 'odid-9999999'")
//                val courseShoppingCart = sparkSession.sql("select *from dwd.dwd_course_shopping_cart")
//                        .drop("coursename")
//                        .withColumnRenamed("discount", "cart_discount")
//                        .withColumnRenamed("createtime", "cart_createtime")
//                val tmpdata = coursePay.join(courseShoppingCart, Seq("orderid"), "right")
//                tmpdata.show()
//                }
//        }
