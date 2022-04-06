package com.apple.chapter07

object Scala06_Collection_Function {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 常用方法
        val list = List(1,2,3,4)

        println(list.length)
        println(list.size)
        println(list.isEmpty)
        println(list.contains(1))

        list.foreach(println)
        println(list.mkString(","))
        val iterator: Iterator[Int] = list.iterator
        while ( iterator.hasNext ) {
            iterator.next()
        }
        list.productIterator

    }
}
