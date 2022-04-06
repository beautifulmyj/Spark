package com.apple.chapter08

object Scala06_Match {

    def main(args: Array[String]): Unit = {

        // TODO - 偏函数
        // 以偏（部分）概全（整体）

        val list = List(1,2,3,4)

        // map函数其实就需要全量函数
        val newlist = list.map(
            num => {
                if ( num % 2 == 0 ) {
                    num
                } else {
                    num * 2
                }
            }
        )
        println(newlist)

    }
}
