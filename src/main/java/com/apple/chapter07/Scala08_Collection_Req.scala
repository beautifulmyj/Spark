package com.apple.chapter07

object Scala08_Collection_Req {
    def main(args: Array[String]): Unit = {

        // TODO - 不同省份的商品点击排行
        val list = List(
            ("zhangsan", "河北", "鞋"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "鞋"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河南", "衣服"),
            ("wangwu", "河南", "鞋"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "鞋"),
            ("zhangsan", "河北", "鞋"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "帽子"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河南", "衣服"),
            ("wangwu", "河南", "帽子"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "帽子"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "电脑"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河南", "衣服"),
            ("wangwu", "河南", "电脑"),
            ("zhangsan", "河南", "电脑"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "帽子")
        )

        // 将原始数据进行结构的转换
        // word => 河北-帽子
        val words = list.map(
            t => {
                t._2 + "-" + t._3
            }
        )
        // (word,list) => (word,size)
        val groupMap: Map[String, List[String]] = words.groupBy(word=>word)

//        val wordCnt = groupMap.map(
//            t => {
//                (t._1, t._2.size)
//            }
//        )
        val wordCnt: Map[String, Int] = groupMap.mapValues(_.size)

        val prvToItemAndCnt = wordCnt.toList.map(
            kv => {
                val word = kv._1
                val cnt = kv._2
                val ks = word.split("-")
                ( ks(0), (ks(1), cnt) )
            }
        )

        // TODO 根据省份对数据进行分组
        val prvGroupMap: Map[String, List[(String, (String, Int))]] =
            prvToItemAndCnt.groupBy(_._1)

        val result = prvGroupMap.mapValues(
            list => {
                val itemCntList = list.map(_._2)
                itemCntList.sortBy(_._2)(Ordering.Int.reverse).take(3)
            }
        )

        println(result)



    }
}
