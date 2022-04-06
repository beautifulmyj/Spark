package com.apple.chapter06

object Scala07_Object_Method {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 方法
        // 所谓的方法，其实就是在类中声明的函数
        // 声明类后，会自动存在一些方法
        // 所有的类都继承了Object
        val user = new User()
        // == 在scala中其实是非空的equals方法
        // equals方法
        // eq 其实就是java的双等号
        //user.eq(user1)
        // equals方法和hashCode一般情况下都是要重写
        // 向HashMap中存数据 => hashCode => equals
        //user.hashCode()
        //user.asInstanceOf[User]

        Predef.println()
        //val userClass: Class[User] = Predef.classOf[User]



    }
    class User {
        var id : Int = 0
        override def equals(obj: Any): Boolean = {
            if ( obj.isInstanceOf[User] ) {
                val other = obj.asInstanceOf[User]
                this.id == other.id
            } else {
                false
            }
        }
    }
}
