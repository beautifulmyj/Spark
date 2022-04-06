package com.apple.chapter07

object Scala01_Collection_Array {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 数组 - Array
        // 这里的Array其实就等同于java的数组

        // 创建数组
        // 编译后和java数组是一样的
        // scala中中括号表示泛型
        // 泛型和类型的区别？
        // String[] args = new String[3]
        // args[0] = "a"
        // args[1] = "b"
        val array = new Array[String](3)

        // scala中使用索引访问数组的元素，采用的是小括号。
        array(0) = "zhangsan"
        array(1) = "lisi"
        array(2) = "wangwu"
        // 如果超过索引范围，也会出现错误
        //array(3) = "zhaoliu"
        println(array)
    }

}
