package com.apple.chapter06

object Scala11_Object_Interface_1 {

    def main(args: Array[String]): Unit = {

        // 面向接口编程

        // trait可以继承其他的类
        // trait中可以声明抽象方法, 混入的类需要重写抽象方法
        // trait中可以声明完整的方法。
        new Dog()
    }
    trait Run extends User{
        def test()
        def test1(): Unit = {

        }
    }
    class Person extends Run{
        override def test(): Unit = {

        }
    }
    class Dog extends Run {
        override def test(): Unit = {

        }
    }
}

