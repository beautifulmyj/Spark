package com.apple.chapter07

object Scala02_Collection_Seq_1 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - Seq
        // 如果声明一个空集合，一般采用List(),有特定的对象来代替
        //println(Nil)
        // 一般构建List数据
        val list = (1 :: (2 :: (3 :: (4 :: Nil))))

        val list1 = List(1,2,3,4)

        // :: 这个运算符其实就是简单的增加数据
        val list2 = 1 :: 2 :: 3 :: list1 :: Nil
        // ::: 这个运算符也是增加数据，但是存在一个扁平化的概念
        // 所谓的扁平化的概念,就是将一个整体拆分成一个一个的个体来使用的方式
        val list3 = 1 :: 2 :: 3 :: list1 ::: Nil

        println(list2)
        println(list3)

    }

}
