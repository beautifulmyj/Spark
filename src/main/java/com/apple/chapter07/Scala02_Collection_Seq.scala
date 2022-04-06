package com.apple.chapter07

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Scala02_Collection_Seq {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - Seq
        // 一般scala中集合对象的创建都是采用伴生对象的apply方法。
        // scala中默认提供的集合都是不可变的
        //val seq = Seq(1,2,3,4)
        val list = List(1,2,3,4)

        val ints1: List[Int] = list :+ 5
        val ints2 = 5 +: list

        println(list)
        println(ints1)
        println(ints2)

        //ListBuffer(1,2,3,4).re

    }

}
