package com.apple.chapter08

object Scala04_Match_1 {

    def main(args: Array[String]): Unit = {

        // 模式匹配的用法
//        val map = Map(
//            ("a", 1), ("b", 2), ("c", 3)
//        )

//        for ( (k, v) <- map ) {
//            println(k + "=" + v)
//        }
//        for ( (k, 2) <- map ) {
//            println(k)
//        }

        //val (id, name, age) = (1, "zhangsan", 30)

        //println(name)

        val list = List(

            ( "a", 1 ), ("b", 2), ("c", 3)

        )

//        val newlist = list.map(
//            (t) => {
//                (t._1, t._2 * 2)
//            }
//        )

        // 在功能函数中使用模式匹配时，需要增加case关键字来明确使用模式匹配语法
        // 功能函数小括号需要修改为大括号
//        val newlist = list.map {
//            case (word, cnt) => {
//                (word, cnt * 2)
//            }
//        }
//        println(newlist)

        val list2 = List(
            (("河北", "鞋"), 20),
            (("河北", "衣服"), 40),
            (("河北", "帽子"), 30)
        )

        // (("河北", "鞋"), 20) => ("河北", ("鞋", 40)),
//        list2.map(
//            t => {
//                ( t._1._1, ( t._1._2, t._2 * 2 ) )
//            }
//        )
        list2.map {
            case ((prv, item), cnt) => {
                (prv, (item, cnt * 2))
            }
        }
    }
}
