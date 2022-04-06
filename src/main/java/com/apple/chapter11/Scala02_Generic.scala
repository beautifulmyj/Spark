package com.atguigu.bigdata.scala.chapter11

object Scala02_Generic {

    def main(args: Array[String]): Unit = {

        // 上限 采用颜文字 <:
//        val c = new Consumer[User]
//        val m: Message[_ <: User] = c.consume()
//        val data: User = m.data

        // 下限 采用颜文字 >:

        val p = new Producer[User]()
        p.produce(new Message[User]())
        //p.produce(new Message[Child]())
        p.produce(new Message[Parent]())

    }
    class Producer[T] {
        def produce( m : Message[_ >: T] ): Unit = {

        }
    }
    class Consumer[T] {
        def consume(): Message[_ <: T] = {
            null
        }
    }
    class Message[T] {
        var data : T = _
    }
    class Parent {

    }
    class User extends Parent{

    }
    class Child extends User {

    }
}
