package com.atguigu.bigdata.scala.chapter11

object Scala04_Generic {

    def main(args: Array[String]): Unit = {
        def f[A : Test](a: A) = {
            println(a)
        }
        implicit val test : Test[SubUser] = new Test[SubUser]
        f( new SubUser() )
    }
    class Test[T] {
    }
    class Parent {
    }
    class User extends Parent{
    }
    class SubUser extends User {
    }
}
