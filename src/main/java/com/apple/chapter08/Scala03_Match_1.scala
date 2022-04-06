package com.apple.chapter08

object Scala03_Match_1 {

    def main(args: Array[String]): Unit = {
        // 匹配数组
        for (arr <- Array(
            Array(0),
            Array(1, 0),
            Array(0, 1, 0),
            Array(1, 1, 0),
            Array(1, 1, 0, 1),
            Array("hello", 90))) { // 对一个数组集合进行遍历
            val result = arr match {
                case Array(0) => "0" //匹配Array(0) 这个数组
                case Array(x, y) => x + "," + y //匹配有两个元素的数组，然后将将元素值赋给对应的x,y
                case Array(0, _*) => "以0开头的数组" //匹配以0开头和数组
                case _ => "something else"
            }
            //println("result = " + result)
        }

        // 匹配列表
        for (list <- Array(
            List(0),
            List(1, 0),
            List(0, 0, 0),
            List(1, 0, 0),
            List(88))) {
            val result = list match {
                case List(0) => "0" //匹配List(0)
                case List(x, y) => x + "," + y //匹配有两个元素的List
                case List(0, _*) => "0 ..."
                case _ => "something else"
            }

            //println(result)
        }

        val list: List[Int] = List(1)

        // 1 :: 2 :: Nil

        list match {
            case first :: second :: rest => println(first + "-" + second + "-" + rest)
            case _ => println("something else")
        }
    }
}
