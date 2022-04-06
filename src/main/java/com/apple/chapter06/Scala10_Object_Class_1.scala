package com.apple.chapter06

object Scala10_Object_Class_1 {

    def main(args: Array[String]): Unit = {

        // TODO 构造方法私有化
        // 将private关键字声明在构造方法小括号的前面
        // 伴生对象是可以访问伴生类中的私有内容
        //val user = User.getInstance()
        // 一般情况下，通过伴生对象构建伴生类对象的方法，都起名为apply
        // apply方法，编译器可以自动识别，可以省略
        // apply方法可以重载的
        //val user1 = User.apply()
        val user1 = User("zhangsan")
        val user2 = User()
        println(user2)

        Range(1,10) // Range.apply(1, 10)

    }
    class User private() {

    }
    object User {
        def getInstance() = {
            new User()
        }

        def apply() = new User()
        def apply(name:String) = new User()
    }
}

