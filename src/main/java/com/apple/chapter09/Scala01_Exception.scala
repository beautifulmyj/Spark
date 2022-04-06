package com.apple.chapter09

import java.io.FileInputStream

object Scala01_Exception {

    def main(args: Array[String]): Unit = {

        // Scala中的异常没有分类,所以没有必须要处理的概念
        // 没有throws关键字
        // scala中的异常处理采用的模式匹配(类型匹配)
        try {
            //val i = 0
            //val j = 10 / i
            new  FileInputStream(new java.io.File("xxxxxxx"))
        } catch {
            //case e : Exception => println("exception")
            case e : ArithmeticException => println("ArithmeticException")

        } finally {
            println("yyyyy")
        }

    }
}
