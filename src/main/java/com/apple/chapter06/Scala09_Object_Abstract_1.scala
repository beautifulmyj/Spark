package com.apple.chapter06

object Scala09_Object_Abstract_1 {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 抽象属性
        // 不完整的属性就是抽象属性
        // 一个类中如果有抽象属性，那么这个类就是抽象类
        // 子类需要将属性补充完整，否则也是抽象类

        // 所谓的抽象属性，在scala编译时，并不会产生属性，而是生成抽象的set,get方法
        // 子类将属性补充完整，其实就等同于将父类的抽象属性进行重写
        // 所谓的抽象属性在底层其实还是抽象方法。

        // 子类可以重写父类的完整属性需要增加override
        // 不能重写var声明的变量
        // 1. var, val
        // 2. 重写的概念
        new Child().test()

    }
    abstract class User {
        var name : String
        val age : Int = 20

        def test(): Unit = {
            //age = 40   // setAge(40)
            println(age) // getAge()
        }
    }
    class Child extends User {
        var name : String = "zhangsan"
        override val age : Int = 30
    }
}
