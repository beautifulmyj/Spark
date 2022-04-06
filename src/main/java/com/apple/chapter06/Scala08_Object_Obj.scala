package com.apple.chapter06

object Scala08_Object_Obj {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 对象 - 构造方法
        // scala中默认给类提供了无参的构造方法
        // scala中的构造方法不是方法名和类名一致。
        // scala中是一个完全面向函数式编程的语言，万物皆函数
        // 类其实也是函数
        // 类名的后可以增加小括号（参数列表），所以类也是一个函数(构造函数)
        val user = new User("zhangsan")




    }
    class User(name:String) {
        // 函数体 & 类体
        println("name = " + name)
    }
}
