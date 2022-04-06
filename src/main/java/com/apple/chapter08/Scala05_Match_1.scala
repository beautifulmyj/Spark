package com.apple.chapter08

object Scala05_Match_1 {

    def main(args: Array[String]): Unit = {

        // TODO - 模式匹配 - 匹配对象
        val user = new User( "lisi", 40 )
        user match {
            case User("lisi", 40) => println("用户为lisi")
            case _ => println("啥也不是")
        }

    }
    // 样例类，专门用于模式匹配的。
    // 1. 编译后的类生成了大量的方法可以使用
    // 2. 自动生成伴生对象
    // 3. 自动生成伴生对象的apply，unapply方法
    // 4. 默认类实现了可序列化接口
    // 5. 样例类中构造参数默认为val声明，不能修改，但是可以显示地使用var声明
    case class User( var name:String, age : Int )
}
