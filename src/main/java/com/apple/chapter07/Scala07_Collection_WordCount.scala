package com.apple.chapter07

import scala.io.{BufferedSource, Source}
import scala.math.Ordering

object Scala07_Collection_WordCount {
    def main(args: Array[String]): Unit = {

        // TODO WordCount

        // 1. 读取文件获取原始数据
        //    line
        val source: BufferedSource = Source.fromFile("data/word.txt")
        val list: List[String] = source.getLines().toList
        source.close()

        // 2. 将原始数据拆分成一个一个的单词（分词效果）
        //    line => word
        val words: List[String] = list.flatMap(_.split(" "))

        // 3. 将相同的单词放置在一个组中
        //   word => List(word, word, word)
        val wordGroupMap: Map[String, List[String]] = words.groupBy(word=>word)

        // 4. 将分组后的结果进行统计
        //  （word, list） => (word, list.size)
        val wordCount = wordGroupMap.map( kv=>{
            ( kv._1, kv._2.size)
        } )

        // 5. 将统计结果根据数量进行排序（降序）
        val sortList: List[(String, Int)] = wordCount.toList.sortBy(_._2)(Ordering.Int.reverse)

        // 6. 将排序后的结果取前3名（Top3）
        val top3 = sortList.take(3)

        println(top3)

    }
}
