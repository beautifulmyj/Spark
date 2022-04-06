package com.apple.chapter07

object Scala06_Collection_Function_2 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 常用方法
        val list1 = List(1,2,3,4)
        val list2 = List(3,4,5,6,7)

        // 交集，并集，差集
        //println("交集 ：" + list1.intersect(list2)) // 3，4

        //println("并集 ：" + list1.union(list2)) // 1，2，3，4，3，4，5，6

        //println("差集 ：" + list1.diff(list2)) // 1， 2

        // 拉链
        //println("拉链 : " + list1.zip(list2))

        // 将集合中的一部分数据当成整体
        // 获取集合中每三条数据的和。
        val list3 = List(1,2,3,4)
        val iterator: Iterator[List[Int]] = list3.sliding(3)
        while ( iterator.hasNext ) {
            val list = iterator.next()
            println(list + " 求和 ：" + list.sum)
        }

        println(list3.max)
        println(list3.min)
        println(list3.product) // 乘积


    }
}
