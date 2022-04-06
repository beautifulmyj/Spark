package com.apple.chapter06

object Scala11_Object_Interface {

    def main(args: Array[String]): Unit = {

        // 面向接口编程
        // Scala中没有接口的概念，而且没有interface的关键字。
        // 将多个对象中相同的特征从对象中剥离出来， 形成一种特殊的结构
        // 这个结构称之为特征（特质），如果一个对象符合这个特征，那么就可以将这个特征混入到类中
        // 这个特征（特质）采用关键字trait
        // 一个类如果需要【混入】这个特征，采用extends关键字
        // 将trait理解为接口和抽象类的结合体

    }
    trait Run {

    }
    class Person extends Run{

    }
    class Dog extends Run {

    }
}

