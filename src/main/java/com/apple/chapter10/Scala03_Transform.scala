package com.apple.chapter10

object Scala03_Transform {

    def main(args: Array[String]): Unit = {

        // 隐式转换的作用
        // 1. 解决类型之间的差异问题
        // 2. 扩展功能
        implicit def transform( user:User ): Parent = {
            new Parent()
        }

        // 动态混入功能在构建对象时使用
        //**************************
        val user = new User()
        user.insertUser()
        user.updateUser()
        //**************************
    }
    trait UpdateData {
        def updateUser(): Unit = {
            println("update user...")
        }
    }
    class Parent {
        def updateUser(): Unit = {
            println("update user...")
        }
    }
    class User{
        def insertUser(): Unit = {
            println("insert user...")
        }
//        def updateUser(): Unit = {
//            println("update user...")
//        }
    }
}
