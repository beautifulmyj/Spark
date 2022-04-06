package com.apple.chapter08

object Scala01_Match {

    def main(args: Array[String]): Unit = {

        // TODO scala中的模式匹配的语法类似于java的switch语法
        // scala中没有switch语法。
        // scala为了实现数据的比对（值，类型，集合结构），采用了特殊的语法
        // 称之为模式匹配，使用的关键字为match
        val a : Int = 10

        a match {
            case 10 => println("10")
            case 20 => println("20")
        }
    }
}
