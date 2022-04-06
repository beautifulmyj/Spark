package com.apple.chapter10

object Scala02_Transform {

    def main(args: Array[String]): Unit = {

        implicit def transform( d : Double ): Int = {
            d.toInt
        }
        // 在相同的作用域中，相同的隐式转换规则不能重复
        // 隐式函数：在函数声明前增加implicit关键字，可以在编译时，被编译器识别
//        implicit def transform1( d : Double ): Int = {
//            d.toInt
//        }
        // ********************
        val user = new User()
        user.age = 30

        val age : Int = user.age
        println(age)
        // ********************

    }
    // lib -> jar
    class User {
        var age : Double = _
    }
}
