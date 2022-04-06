package com.atguigu.bigdata.scala.chapter11

object Scala03_Generic {

    def main(args: Array[String]): Unit = {

        //val list : List[Int] = List(1,2,3,4)

        //val i = list.reduce(_+_)

        //println(i)
        val list : List[User] = List(
            new User(), new User(), new User()
        )

        //val user: User = list.reduce((x, y)=> x)
        //val child: Child = list.reduce[Child]((x, y)=> x)
        val child: Parent = list.reduce[Parent]((x, y)=> x)
        println(child)
    }
    class Parent {

    }
    class User extends Parent{

    }
    class Child extends User {

    }
}
