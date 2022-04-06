package com.apple.chapter07

import scala.math.Ordering

object Scala06_Collection_Function_6 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 功能函数（*）

        // TODO 排序
        val list = List(11,4,2,3)

        // sortBy方法根据指定的规则对数据进行排序。默认的排序规则为升序
        def sortFunction( num : Int ): Int = {
            num
        }

        println(list.sortBy(sortFunction).reverse)
        println(list.sortBy(sortFunction)(Ordering.Int.reverse))
        // 降序

    }
}
