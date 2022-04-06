//package com.apple.sparktuning;object SMBJoinTuning {
//
//        def main(args: Array[String]): Unit = {
//                System.setProperty("HADOOP_USER_NAME", "root")
//                val sparkConf = new SparkConf().setAppName("test")
//                        .set("spark.sql.shuffle.partitions", "36")
//                val sparkSession = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate()
//                val ssc = sparkSession.sparkContext
//                ssc.hadoopConfiguration.set("fs.defaultFS", "hdfs://mycluster")
//                ssc.hadoopConfiguration.set("dfs.nameservices", "mycluster")
//                //    useBucket(sparkSession)
//                //    useJoin(sparkSession)
//                useSMBJoin(sparkSession)
//
//                }
//
//        def useBucket(sparkSession: SparkSession) = {
//                sparkSession.read.json("/user/atguigu/ods/coursepay.log")
//                        .write.partitionBy("dt", "dn")
//                        .format("parquet")
//                        .bucketBy(5, "orderid")
//                        .sortBy("orderid").mode(SaveMode.Overwrite)
//                        .saveAsTable("dwd.dwd_course_pay_cluster")
//                sparkSession.read.json("/user/atguigu/ods/courseshoppingcart.log")
//                        .write.partitionBy("dt", "dn")
//                        .bucketBy(5, "orderid")
//                        .format("parquet")
//                        .sortBy("orderid").mode(SaveMode.Overwrite)
//                        .saveAsTable("dwd.dwd_course_shopping_cart_cluster")
//                }
//
//        def useJoin(sparkSession: SparkSession) = {
//                //查询出三张表 并进行join 插入到最终表中
//                        val saleCourse = sparkSession.sql("select *from dwd.dwd_sale_course")
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
//
//                }
//
//        def useSMBJoin(sparkSession: SparkSession) = {
//                //查询出三张表 并进行join 插入到最终表中
//                        val saleCourse = sparkSession.sql("select *from dwd.dwd_sale_course")
//                val coursePay = sparkSession.sql("select * from dwd.dwd_course_pay_cluster")
//                        .withColumnRenamed("discount", "pay_discount")
//                        .withColumnRenamed("createtime", "pay_createtime")
//                val courseShoppingCart = sparkSession.sql("select *from dwd.dwd_course_shopping_cart_cluster")
//                        .drop("coursename")
//                        .withColumnRenamed("discount", "cart_discount")
//                        .withColumnRenamed("createtime", "cart_createtime")
//                val tmpdata = courseShoppingCart.join(coursePay, Seq("orderid"), "left")
//                val result = broadcast(saleCourse).join(tmpdata, Seq("courseid"), "right")
//                result.select("courseid", "coursename", "status", "pointlistid", "majorid", "chapterid", "chaptername", "edusubjectid"
//                        , "edusubjectname", "teacherid", "teachername", "coursemanager", "money", "orderid", "cart_discount", "sellmoney",
//                        "cart_createtime", "pay_discount", "paymoney", "pay_createtime", "dwd.dwd_sale_course.dt", "dwd.dwd_sale_course.dn")
//                        .write.mode(SaveMode.Overwrite).saveAsTable("dws.dws_salecourse_detail_2")
//
//                }
//        }
