package com.apple.chapter06
class Scala10_Object_Class {

}
object Scala10_Object_Class {

    def main(args: Array[String]): Unit = {

        // TODO class <--> object
        // class关键字用于声明类，和java没有区别的
        // object关键字用于声明类, 还可以声明对象(额外的类型)，这个对象是一个单例对象
        // 这个单例对象是在在编译类的时候同时产生的，所以将这个对象称之为伴生对象
        // 和伴生对象相同名称的类，称之为伴生类

        // object对象用于模拟static语法，可以通过类名直接访问方法

        // 伴生类中一般用于声明成员属性或成员方法。
        // 伴生对象中一般用于声明静态属性或静态方法
        println(Scala10_Object_Class)

    }
}
