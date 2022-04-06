package com.apple.chapter08

object Scala06_Match_1 {

    def main(args: Array[String]): Unit = {

        // 将该List(1,2,3,4,5,6,"test")中的Int类型的元素加一，并去掉字符串。
        val list : List[Any] = List(1,2,3,4,5,6,"test")

        /*
        val newlist = list.map(
            data => {
                data match {
                    case i:Int => i + 1
                    case _ => data
                }
            }
        )

        val newlist1 = newlist.filter(!_.isInstanceOf[String])
        //newlist.filter()
         */

        //val newlist1 = list.filter(!_.isInstanceOf[String]).map(_.asInstanceOf[Int] + 1)

        // 声明偏函数
        //val pf = { case 1 => "one" }

        // 偏函数必须在可以使用偏函数的地方使用
        // collect方法支持偏函数
        val newlist1 = list.collect({case i:Int => i + 1})

        println(newlist1)
    }
}
