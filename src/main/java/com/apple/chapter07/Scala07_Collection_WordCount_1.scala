package com.apple.chapter07

import scala.collection.mutable
import scala.io.{BufferedSource, Source}
import scala.math.Ordering

object Scala07_Collection_WordCount_1 {
    def main(args: Array[String]): Unit = {

        // TODO WordCount
        val list = List(
            ("hello", 4),
            ("hello spark", 3),
            ("hello spark scala", 2),
            ("hello spark scala hive", 1)
        )
        // hello hello hello hello
        // hello spark hello spark hello spark
        // hello spark scala hello spark scala
        // hello spark scala hive
        // A(Tuple) => B(String)
        val lines: List[String] = list.map(
            t => {
                (t._1 + " ") * t._2
            }
        )

        println(lines)




    }
}
