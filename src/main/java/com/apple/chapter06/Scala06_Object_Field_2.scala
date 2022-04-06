package com.apple.chapter06

import scala.beans.BeanProperty

object Scala06_Object_Field_2 {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 属性

        // 希望scala中属性的初始化和java的初始化一致
        // 需要采用下划线, val声明的属性不能使用
        val user = new User()


    }
    class User {
        var name : String = _
        val age : Int = 0
    }
}
