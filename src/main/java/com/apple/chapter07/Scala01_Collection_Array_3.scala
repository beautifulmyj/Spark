package com.apple.chapter07

import scala.collection.mutable.ArrayBuffer

object Scala01_Collection_Array_3 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 数组 - Array - 可变
        val buffer = new ArrayBuffer[String]()
        val buffer1 = ArrayBuffer("1111", "2222")

        // 操作数据
        // 增加数据
        buffer.append("zhangsan", "lisi")
        buffer.append("wangwu")
        buffer.appendAll(buffer1)
        // 插入数据
        buffer.insert(1, "zhaoliu", "tianqi")

        // 修改数据
        buffer.update(1, "3333")

        // 删除数据
        //val str: String = buffer.remove(0)
        buffer.remove(0, 10)
        //println(str)

        // 默认情况下，scala自己的集合的打印方式：
        // 集合类名（集合的元素）
        // zhangsan zhaoliu tianqi lisi wangwu 1111 2222
        println(buffer)

    }

}
