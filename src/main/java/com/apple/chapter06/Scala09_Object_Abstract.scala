package com.apple.chapter06

object Scala09_Object_Abstract {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 抽象
        // 所谓的抽象其实就是不完整
        // 不完整的类就是抽象类 : abstract
        // 不完整的方法就是抽象方法 : 只有声明，没有实现
        // 抽象类不能构建对象,如果想要构建对象，一般通过子类完成,子类应该重写方法

        // 抽象类中是可以声明完整的方法的。那么如果子类想要重写完整的方法
        // 需要添加override修饰符
        val user : User = new Child()
        user.test()


    }
    abstract class User {
        def aaa()
        def test(): Unit = {
            println("user test...")
        }
    }
    class Child extends User {
        override def aaa(): Unit = {

        }
        override def test(): Unit = {
            println("child test...")
        }
    }
}
