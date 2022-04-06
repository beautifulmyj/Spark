package com.apple.chapter06

object Scala06_Object_Field {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 属性
        // 所谓的属性，其实就是在类中声明的变量,但是和普通的变量不一样
        // 属性声明的规则：
        // val | var 属性名 : 属性类型 = 属性值
        // 属性声明时，如果采用val，那么在编译时会自动增加final关键字修饰

        // scala中class中声明的属性，其实就是成员属性，需要通过构建对象进行访问
        val user = new User()
        //user.name = "lisi"
        //user.age = 40
        println(user.name)


    }
    class User {
        var name : String = "zhangsan"
        val age : Int = 30
    }
}
