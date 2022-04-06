package com.apple.chapter07

object Scala06_Collection_Function_11 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 函数

        val list = List(1,2,3,4)
        // 如果想要将fold方法的执行过程的数据保存下来，可以采用特殊的方法
        println(list.fold(5)(_ + _))
        println(list.scan(5)(_ + _))
        println(list.scan(5)(_ - _))
        println(list.scanLeft(5)(_ - _))

        println(list.scanRight(5)(_ - _))
    }
}
