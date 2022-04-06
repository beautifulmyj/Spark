package com.apple.chapter07

import scala.collection.mutable

object Scala04_Collection_Map_1 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - Map
        val map : mutable.Map[String, Int] = mutable.Map("a"->1, "b"->2, "c"->3)

        // put : 放
        // 增加（修改）
        //map.put("a", 4)

        // 修改
        //map.update("d", 4)

        // 删除
        //map.remove("a")

        // 循环
        //map.foreach()
        //map.mkString()

        // 获取一个数据
        // Some(1), None
        // get方法返回的是一个Option类型(选项类型)
        // Some. None
        // scala为了避免出现空指针异常
        //val maybeInt: Option[Int] = map.get("a")
//        if ( maybeInt.isEmpty ) {
//            println("map中没有对应a的值")
//        } else {
//            println("map中有对应a的值:" + maybeInt.get)
//        }
        //println(maybeInt.getOrElse(0))

        val i: Int = map.getOrElse("a", 0)
        println(i)

    }

}
