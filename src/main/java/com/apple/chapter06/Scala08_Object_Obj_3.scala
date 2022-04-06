package com.apple.chapter06

object Scala08_Object_Obj_3 {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 对象 - 构造方法
        // 父子关系
        // 主 & 辅助
        new User()

        // 11111
        // 33333
        // 44444
    }
    class Person(name:String) {
        println("11111")
        def this() {
            this("zhangsan")
            println("22222")
        }
    }
    class User( name:String) extends Person(name){
        println("33333")
        def this() {
            this("wangwu")
            println("44444")
        }
    }
}
