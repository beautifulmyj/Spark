package com.apple.chapter07

object Scala06_Collection_Function_4 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 功能函数（*）
        val list = List(
            List(1,2), List(3,4)
        )

        val list1 = List(
            List(
                List(1,2)
            ),
            List(
                List(3,4)
            )
        )

        // TODO 扁平化 flatten
        // 1,2,3,4
        // 将集合中整体拆成一个一个的个体来使用的方式，称之为扁平化操作
        // 只能对最外层的集合进行扁平化，不能嵌套使用
        //println(list)
        //println(list.flatten)
        //println(list1.flatten)

        //val s : String = "Hello Scala Hadoop Hive"
        val ss = List(
            "Hello Scala Hadoop Hive"
        )

        // scala语言中，可以将字符串当成char数组来使用
        //println(ss.flatten)
        // 如果想要自定义扁平化规则，需要采用特殊的功能函数
        // flatMap可以将集合中的每一个元素按照指定的规则进行扁平化
        // 1 => N
        def flatMapFunction( s:String ): Array[String] = {
            s.split(" ")
        }

        //println(ss.flatMap(flatMapFunction).mkString(","))
        println(ss.flatMap(_.split(" ")).mkString(","))

    }
}
