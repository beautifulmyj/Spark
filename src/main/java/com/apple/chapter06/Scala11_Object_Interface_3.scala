package com.apple.chapter06

object Scala11_Object_Interface_3 {

    def main(args: Array[String]): Unit = {

        // OCP
        // 动态混入
        val user = new User() with UserExt
        user.insertUser()
        user.updateUser()
    }
//    class Parent {
//        def updateUser(): Unit = {
//            println("update user...")
//        }
//    }
    trait UserExt {
        def updateUser(): Unit = {
            println("update user...")
        }
    }
    class User {
        def insertUser(): Unit = {
            println("insert user...")
        }
//        def updateUser(): Unit = {
//            println("update user...")
//        }
    }
}

