package com.apple.chapter07

object Scala01_Collection_Array_1 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 数组 - Array

        // 采用新的方式创建Array
        // Range(1, 10)
        val array : Array[String] = Array("zhangsan", "lisi", "wangwu")
        val array1 : Array[Int] = Array(1,2,3)
        //val array : Array[String] = Array.apply("zhangsan", "lisi", "wangwu")
        // 通过索引的方式可以设置（修改）数据

        // 获取数据
        //println(array(0))

//        for ( i <- 0 until array.length ) {
//            println(array(i))
//        }
        // 使用函数式的方式来循环数组
//        def test( s : String ): Unit = {
//            println(s)
//        }
        // foreach方法可以让数组中的每一个数据传递到参数中进行处理
//        array.foreach(test)
//        array.foreach(( s : String )=>{println(s)})
//        array.foreach(( s : String )=>println(s))
//        array.foreach(( s )=>println(s))
//        array.foreach(s=>println(s))
//        array.foreach(println(_))
       // array.foreach(println)
        println(array.mkString(", "))

        //array1.foreach()

    }

}
