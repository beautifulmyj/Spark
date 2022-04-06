package com.apple.chapter07

import scala.collection.mutable

object Scala03_Collection_Set_1 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - Set - 可变
        // 数据无序，不可重复
        // 可变set是根据包名来区分
        val set = mutable.Set(1,2,3,4)

        // 增加元素
        set.add(5)
        set.add(6)

        // 修改集合本身
        set.update(4, false)
        set.update(7, true)

        // 删除数据
        set.remove(3)

        //set.foreach()
        //set.mkString()
        println(set)


    }

}
