package com.apple.chapter06

object Scala06_Object_Field_3 {

    def main(args: Array[String]): Unit = {

        // TODO - 面向对象 - 属性
        // 访问权限
        //val user = new User()
        /*
          TODO scala中的访问权限也有4种：
          private : 私有权限 => 同类
          private[包名] : 包访问权限(包私有) => 同类，同包(同一个包下的所有子包)
          protected : 受保护的权限 => 同类，子类
          (default) : 公共的。scala中没有public关键字。

         */

        val emp = new parent.child1.Emp()
        //emp.name
        // TODO 任意
        //println(emp.age)
        //println(emp.email)
        println(emp.password)


    }
    class User {
        var name : String = _
        val age : Int = 0
    }
}
package parent {
    package child1 {
        class Emp {
            private var name : String = "zhangsan"
            private[child1] var age : Int = 30
            protected var email : String = "xxxxx"
            var password : String = "yyy"

            def test(): Unit = {
                // TODO 同类
                println("name = " + name)
                println("age = " + age)
                println("email = " + email)
                println("password = " + password)
            }
        }
        class Classes {
            def test(): Unit = {
                // TODO 同包
                val emp = new Emp()
               // println(emp.name)
               println(emp.age)
               println(emp.password)
               //println(emp.email) // protected
            }
        }
    }
    package child2 {

        import com.apple.chapter06.parent.child1.Emp

        class Student extends parent.child1.Emp {

            def test1(): Unit = {
                // 子类
                //println(this.name) // private
                //println(this.age) // private[child1]
                //println(this.email)
                println(this.password)
            }
        }
    }
}
