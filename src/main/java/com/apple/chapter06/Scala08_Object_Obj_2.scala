package com.apple.chapter06

object Scala08_Object_Obj_2 {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 对象 - 构造方法

        // 构造方法中传参数, 一般是为了给属性赋值
        // scala简化了这个操作，可以通过特殊的方式(var, val)，直接让参数作为属性来使用
        val user = new User("zhangsan")
        //user.name

    }
    class User( name:String){

    }
}
