package com.apple.chapter07

object Scala06_Collection_Function_8 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 函数

        // 过滤
        val list = List(1,2,3,4)

        // filter方法用于将集合中的每一个数据进行筛选过滤
        // filter方法参数是需要返回布尔类型值，如果为true，表示数据保留
        // 相反，数据丢弃
        def filterFunction(num:Int): Boolean = {
            num%2 != 0
        }

        //println(list.filter(filterFunction))
        println(list.filter(_%2 != 0))
    }
}
