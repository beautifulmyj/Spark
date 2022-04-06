package com.apple.chapter01

import com.apple.bean.Boy

object Scala02_Test {
    def main(args: Array[String]): Unit = {

        //System.out.println(Scala02_Test.test())
        // scala中println方法底层调用的其实就是java中的打印
        //println(Scala02_Test.test())
//        println(test())
        println(Boy.name)
    }
    // 模仿方法的声明
    def test(): String = {
        return "zhangsan"
    }
}
