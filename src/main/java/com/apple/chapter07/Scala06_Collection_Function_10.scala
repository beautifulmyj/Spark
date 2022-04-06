package com.apple.chapter07

object Scala06_Collection_Function_10 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 函数

        val list = List(1,2,3,4)
//
//        val i = list.reduce(
//            (x, y) => {
//                println(x + "+" + y + "=" + (x + y))
//                x + y
//            }
//        )
//        println("result = " + i)
        // reduce相关的方法只能对集合内部的数据进行计算
        // 如果想要和集合之外的数据进行计算，做不到。
        // Scala中提供了一个折叠的方法（fold）
        // fold方法也是两两计算
        // fold方法存在函数柯里化，有2个参数列表
        // 第一个参数列表中的参数表示计算的初始值
        // 第二个参数列表中的参数表示计算的规则

        // fold方法的底层其实就在调用foldLeft方法
        val i = list.fold(5)(_-_)
        println(i)

        val i1 = list.foldLeft(5)(_-_)
        println(i1)

        // (1 - (2 - (3 - 4))) = -2
        // reversed.foldLeft(z)((x, y) => op(y, x))
        // 1 2 3 4
        // 5 4 3 2 1
        // 1 - (2 - (3 - (4 - 5)))
        val i2 = list.foldRight(5)(_-_)
        println(i2)
    }
}
