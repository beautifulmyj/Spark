package com.apple.chapter08

object Scala05_Match {

    def main(args: Array[String]): Unit = {

        // TODO - 模式匹配 - 匹配对象
        val user = new User( "lisi", 40 )

        // scala中模式匹配在匹配对象时，采用反向操作的方式实现对象的比较
        // (zhangsan, 30) => apply => User
        // User => unapply =>(zhangsan, 30)
        user match {
            case User("lisi", 40) => println("用户为lisi")
            case _ => println("啥也不是")
        }

    }
    class User( var name:String, var age : Int )
    // 伴生对象没有构造方法
    object User {
        def apply( name:String, age:Int ) = new User(name, age)

        def unapply(arg: User): Option[(String, Int)] = {
            Option((arg.name, arg.age))
        }
    }
}
