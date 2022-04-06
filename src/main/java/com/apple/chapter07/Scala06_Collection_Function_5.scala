package com.apple.chapter07

object Scala06_Collection_Function_5 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 功能函数（*）
        val list = List(1,2,3,4)
        // 0 => 偶数 （2=>0,4=>0）
        // 1 => 奇数 （1=>1,3=>1）
        // groupBy方法表示将集合中的每一个元素按照指定的规则进行分组
        // 分组需要根据key(组名)进行分组
        def groupFunction(num : Int) = {
//            if ( num % 2 == 0 ) {
//                "男"
//            } else {
//                "女"
//            }
            num % 2
        }

        // Map(男 -> List(2, 4), 女 -> List(1, 3))
        // groupBy会返回一个Map集合
        // 集合中key就是分组的key(组名)
        // 集合中value是相同组名的数据的集合
        println(list.groupBy(groupFunction))
        println(list.groupBy(_%2))

    }
}
