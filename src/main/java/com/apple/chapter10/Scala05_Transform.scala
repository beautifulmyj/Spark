package com.apple.chapter10

object Scala05_Transform {

    def main(args: Array[String]): Unit = {

        val user = new User()
        user.insertUser()
        user.updateUser()

    }
    // 隐式类：在类的声明时，增加implicit关键字
    // 1. 隐式类需要声明主构造函数，其中只能有一个参数（对象类型）
    implicit class UserExt(user:User) {
        def updateUser(): Unit = {
            println("update user...")
        }
    }
    class User {
        def insertUser(): Unit = {
            println("insert user...")
        }
    }
}
