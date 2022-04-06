package com.apple.chapter07

import scala.collection.mutable

object Scala05_Collection_Tuple {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - Tuple
        // scala可以将无关的数据封装成一个整体来使用。这个整体其实就是元素的组合
        // 简称为元组（Tuple）,元组采用小括号进行封装
        // 元组的类型是 ： (第一个元素的类型，第二个元素的类型....)

        // 1, zhangsan, 30
       // val t : ( Int, String, Int, Int )= (1, "zhangsan", 30, 20)
        // 元组中的数据是根据顺序号访问
//        println(t._1)
//        println(t._2)
//        println(t._3)
//        println(t._4)

        // 元组中能够放置的数据的个数:22
        val t = (
                1,2
        )

        // 使用索引的方式访问数据
        //t.productElement(index)
        // 迭代器
        //t.productIterator()
        // 元组中没有foreach方法, mkString的
        //t.mk

        // 如果元组中的元素的个数只有2个的情况下，称之为对偶元组，也称之为键值对
        // Map中是可以存放对偶元组。
        //val t1 = "a".->(1)

        //"a" -> 1 -> 2 -> 3

        val map : Map[String, Int] = Map(
            ("a", 1), ("b", 2), ("c", 3)
        )

        val list: List[(String, Int)] = map.toList
        val set: Set[(String, Int)] = map.toSet

        for ( kv <- map ) {
            println(kv._1 + "=" + kv._2)
        }

        println(t)

    }
}
