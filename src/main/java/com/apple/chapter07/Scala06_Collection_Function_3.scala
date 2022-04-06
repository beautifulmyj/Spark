package com.apple.chapter07

object Scala06_Collection_Function_3 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 功能函数（*）
        val list = List(1,2,3,4)

//        val newList = for ( i <- list ) yield {
//            i * 2
//        }
        // TODO => map : 映射（关联） A=>B
        // map方法可以将集合中的每一个数据进行函数进行处理
        def mapFunction(i:Int): Int = {
            i * 2
        }

        //val newList = list.map(mapFunction)
        //val newList = list.map((i:Int)=>{i * 2})
        //val newList = list.map((i:Int)=>i * 2)
        //val newList = list.map((i)=>i * 2)
        //val newList = list.map(i=>i * 2)
        val newList = list.map(_ * 2)

        println(newList)


    }
}
