package com.apple.chapter07

object Scala06_Collection_Function_9 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 函数
        val list = List(1,2,3,4,5)
        //val sum = list.sum
        //list.head - list.tail.sum
        //println(sum)
        // 扁平化： 1 => N
        // scala提供了一些计算方法，但是具体计算逻辑不确定，需要通过参数指定
        // 聚合（简化，规约）reduce ：N => 1

        // scala中基本的运算原理其实就是两两计算
//        val reduceResult = list.reduce(
//            (x:Int, y:Int) => {
//                x + y
//            }
//        )
//
//        val reduceResult = list.reduce(
//            (x:Int, y:Int) => x + y
//        )
//
//        val reduceResult = list.reduce(
//            (x, y) => x + y
//        )

        // reduce的底层调用的其实就是reduceLeft方法
        // reduce方法需要两两计算的数据和返回值结果的类型保持一致
        // (A1, A1) => A1
        val reduceResult = list.reduce(_ - _)

        // reduceLeft两两计算的数据类型可以不一样，但是计算结果的类型
        // 应该和第一个值的类型保持一致
        // 所以reduce方法其实是reduceLeft方法的特殊情况
        // (B, Int) => B
        // -13
        // reduceLeft从左边两两加括号
        // （（（（1 - 2）- 3）- 4）- 5）
        val result1 = list.reduceLeft(_-_)

        // -5
        // reversed.reduceLeft[B]((x, y) => op(y, x))
        // 1 2 3 4 5
        // 5 4 3 2 1
        // 1 - (2 - (3 - (4 - 5)))
        // reduceRight从右边两两加括号
        // （1 -（2 -（3 -（4 - 5））））
        val result2 = list.reduceRight(_-_)


        println(reduceResult)
        println(result1)
        println(result2)
    }
}
