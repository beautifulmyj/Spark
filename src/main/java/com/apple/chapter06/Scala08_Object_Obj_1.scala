package com.apple.chapter06

object Scala08_Object_Obj_1 {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 对象 - 构造方法
        // scala默认给类提供无参的构造方法
        // 但是想要更多的构造方法？
        // 构造方法的作用：
        // 1. 对象的构建
        // 2. 类的初始化
        // scala也可以提供多个构造方法，但是分成2大类
        // 1. 主构造方法 => 完成类的初始化
        // 2. 辅助构造方法 => 属性的赋值以及一些相关的辅助功能
        //                    采用特殊的关键字(this)声明辅助构造方法
        //                    辅助构造方法必须直接或间接地调用主构造方法
        //                    辅助构造方法可以重载的
        //                    辅助构造方法在互相调用时，应该提前声明。
        val user1 = new User("zhangsan")
        val user2 = new User()




    }
    class User(name:String){
        // 函数体 & 类体
        //println("name = " + name)
        def this() {
            this("zhangsan")
        }
        def this(age:Int) {
            this()
        }
    }
}
