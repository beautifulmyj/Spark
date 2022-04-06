package com.apple.chapter06

object Scala11_Object_Interface_2 {

    def main(args: Array[String]): Unit = {

        // 面向接口编程

        // trait可以继承其他的类
        // trait中可以声明抽象方法, 混入的类需要重写抽象方法
        // trait中可以声明完整的方法。

        // 如果一个类没有显示的父类的话，那么混入的特质采用extends关键字
        // 如果一个类有显示的父类，那么父类的继承采用extends关键字
        //          想要混入特质就需要采用特殊的关键字 with
        //          如果混入多个特质，那么需要多个with
        new C()



        // 接口和当前类有关，和父子类无关
        // 相同级别的类和特质，初始化特质优先
        // 相同级别的特质，初始化顺序为从前到后，从左到右
    }
    trait A {
        println("aaaaa")
    }
    trait D {
        println("ddddd")
    }
    trait E extends D{
        println("eeeee")
    }
    class B extends A{
        println("bbbbb")
    }
    class C extends B with A with D with E{
        println("ccccc")
    }
}
// aaaaa
// bbbbb
// ddddd
// eeeee
// ccccc

