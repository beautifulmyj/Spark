package com.apple.chapter10

import com.apple.chapter10.Scala06_Transform.User

object Scala06_Transform extends Parent with MyTrait{

    def main(args: Array[String]): Unit = {

        // 隐式转换的作用域：
        // 1. 当前类中
        // 2. 父类和对应的伴生对象
        // 3. 混入特质和对应的伴生对象
        // 4. 包对象

        // 工作中，一般直接导入使用
        import com.apple.chapter10.Transform._
        val user = new User()
        user.insertUser()
//        user.updateUser()

    }
    // 隐式类：在类的声明时，增加implicit关键字
    // 1. 隐式类需要声明主构造函数，其中只能有一个参数（对象类型）
    // 2. 隐式类不能声明为顶级对象
//    implicit class UserExt1(user:User) {
//        def updateUser(): Unit = {
//            println("update user...")
//        }
//    }
    class User {
        def insertUser(): Unit = {
            println("insert user...")
        }
    }
}
class Parent {
//    implicit class UserExt1(user:User) {
//        def updateUser(): Unit = {
//            println("update user...")
//        }
//    }
}
object Parent {
//    implicit class UserExt1(user:User) {
//        def updateUser(): Unit = {
//            println("update user...")
//        }
//    }
}
trait MyTrait {
//    implicit class UserExt1(user:User) {
//        def updateUser(): Unit = {
//            println("update user...")
//        }
//    }
}
object MyTrait {
//    implicit class UserExt1(user:User) {
//        def updateUser(): Unit = {
//            println("update user...")
//        }
//    }
}