package com.apple.chapter10

object Scala01_Transform {

    def main(args: Array[String]): Unit = {
        // 程序编译出现错误时，编译器会尝试在作用域范围内查找可以让程序编译通过的转换规则
        // 如果找到，那么会自动完成转换操作，重新编译，也称之为二次编译
        // 如果找到，完成的转换操作，我们看不见，所以也称之隐式转换
        // 需要将编译器可以执行的转换规则加标记（关键字）
        implicit def transform( d : Double ): Int = {
            d.toInt
        }
        // ********************
        val user = new User()
        user.age = 30

        val age : Int = user.age
        println(age)
        // ********************


        val name = "zhangsan"

        //name.substring(0,1)
        //name.charAt(0)
        // object.apply = new class
        // object中可以声明apply方法 => User.apply() => User()
        // class中也可以声明apply方法 => new User().apply() =>
        // val user = new User() => user.apply() => user()

        // name.apply(0)
        // String => StringOps
        //println(name(0))
        //println(name.apply(0))


    }
    // lib -> jar
    class User {
        var age : Double = _
    }
}
