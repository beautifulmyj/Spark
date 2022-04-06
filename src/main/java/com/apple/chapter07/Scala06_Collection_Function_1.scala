package com.apple.chapter07

object Scala06_Collection_Function_1 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 常用方法
        val list = List(1,2,3,4)

        // 获取集合中的一部分数据
        println(list.take(3))
        // 反转
        println(list.reverse.take(3).reverse)

        println(list.takeRight(3))

        println(list.drop(1))

        println(list.dropRight(1))

        // 头
        println(list.head)
        // 除了头就是尾
        println(list.tail)
        println(list.tails)
        // 最后一个
        println(list.last)
        // 初始化
        println(list.init)
        println(list.inits)
    }
}
