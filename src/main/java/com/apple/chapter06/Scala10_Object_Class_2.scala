package com.apple.chapter06

object Scala10_Object_Class_2 {

    def main(args: Array[String]): Unit = {

        // TODO 构造方法私有化
        val user1 = new User() // 通过构造方法创建对象
        val user2 = User       // 伴生对象
        val user3 = User()     // 通过伴生对象的apply方法创建对象

    }
    class Use() {

    }
    object User {
        def getInstance() = {
            new User()
        }

        def apply() = new User()
        def apply(name:String) = new User()
    }
}

