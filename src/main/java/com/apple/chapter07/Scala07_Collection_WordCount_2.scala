package com.apple.chapter07

object Scala07_Collection_WordCount_2 {
    def main(args: Array[String]): Unit = {

        // TODO WordCount
        val list = List(
            ("hello", 4),
            ("hello spark", 3),
            ("hello spark scala", 2),
            ("hello spark scala hive", 1)
        )

        // ("hello", 4)
        // ("hello spark", 3) => ("hello",3), ("spark", 3)
        // List(
        //    ("hello", 4),("hello", 3),("hello", 2),("hello", 1),("spark", 3)
        // )

        // hello => List( ("hello", 4),("hello", 3),("hello", 2),("hello", 1) )
        // hello => List(4,3,2,1).sum
        // hello => 10

        val flatList = list.flatMap(
            t => {
                val line = t._1
                val cnt = t._2
                // (spark,2) (hello,2) hive
                val words = line.split(" ")

//                words.map(
//                    word => {
//                        (word, cnt)
//                    }
//                )

                words.map((_, cnt))
            }
        )

        //flatList.groupBy(t=>{t._1})
        val groupMap: Map[String, List[(String, Int)]] = flatList.groupBy(_._1)

        val wordCount = groupMap.map(
            kv => {
                val word = kv._1
                val list = kv._2
                (word, list.map(_._2).sum)
            }
        )

        println(wordCount)




    }
}
