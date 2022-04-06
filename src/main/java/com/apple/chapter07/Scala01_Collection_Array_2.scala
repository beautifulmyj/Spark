package com.apple.chapter07

object Scala01_Collection_Array_2 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 数组 - Array
        // scala中默认提供的集合都是不可变的。
        // 对集合的操作其实都会产生新的集合
        val array = Array(1,2,3,4)
        val array1 = Array(5,6,7,8)

        //array.update()
        //val newArray: Array[Int] = array.+:(5)
        val newArray: Array[Int] = 5 +: array
        // scala中如果运算符是以冒号结尾，那么运算规则为从右向左执行
        //val newArray1: Array[Int] = array +: 5
        val newArray1: Array[Int] = array :+ 5
        //val newArray1: Array[Int] = array.:+(5)

        //println(array.mkString(","))
        //println(newArray.mkString(","))
        //println(newArray1.mkString(","))
        //println(array eq newArray)

        //val newArray2: Array[Int] = array.++:(array1)
        val newArray2: Array[Int] = array1 ++: array
        println(newArray2.mkString(","))
    }

}
