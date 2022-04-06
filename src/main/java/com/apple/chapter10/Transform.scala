package com.apple.chapter10

import com.apple.chapter10.Scala06_Transform.User

object Transform {
    implicit class UserExt1(user:User) {
        def updateUser(): Unit = {
            println("update user...")
        }
    }
}
