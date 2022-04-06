package com.atguigu.bigdata.scala.chapter11

object Scala01_Generic {

    def main(args: Array[String]): Unit = {

        // Scala中的泛型和java的泛型类似
        // java采用尖括号表示泛型，scala中采用中括号表示泛型

        // scala中的泛型也是不可变的。
        // 马丁可以让泛型和类型作为整体使用
        // Test[User] <= Test[Child]
        // 如果Child是User的子类型，那么希望Test[Child]也是Test[User]的子类型
        // 可以采用泛型的变化： 协变
        // 如果Parent是User的父类型，但是希望Test[Parent]也是Test[User]的子类型
        // 可以采用泛型的变化： 逆变
        val t1 : Test[User] = new Test[User]()
        val t2 : Test[User] = new Test[Parent]()
        //val t3 : Test[User] = new Test[Child]()

    }
    class Test[-T] {

    }
    class Parent {

    }
    class User extends Parent{

    }
    class Child extends User {

    }
}
