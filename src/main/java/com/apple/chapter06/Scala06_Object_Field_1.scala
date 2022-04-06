package com.apple.chapter06

import scala.beans.BeanProperty

object Scala06_Object_Field_1 {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 属性
        // scala中声明的属性在编译时，属性其实都是私有的
        // 同时会生成多个公共的方法（类似于set，get方法）。
        // 使用val修饰的属性在编译时不会生成对应的set方法，只有get方法
        val user = new User()
        // scala中给一个对象的属性赋值，其实底层在调用这个属性的set方法
        user.name = "lisi"
        user.setName("xxxx")
        user.getName();
        // scala中访问对象的属性，其实底层在调用这个属性的get方法
        println(user.name)

        // scala中属性的操作不符合java中的Bean规范
        // 可以采用特殊方式（注解）生成符合Bean规范的方法
        // setXXX & getXXX
        // Spring


    }
    class User {
        @BeanProperty
        var name : String = "zhangsan"
        val age : Int = 30
    }
}
