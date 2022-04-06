package com.apple.chapter07

import scala.math.Ordering

object Scala06_Collection_Function_7 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 函数
        val list = List(1,1,1,2,3,2)
        //println(list.distinct)

        val list1 = List("a", "b", "c")

        //println(list1.zipWithIndex)

        // 排序 - Tuple
        // 元组的排序方式：先按照第一个数据进行排序，然后按照第二个数进行排序，依此类推
        // 根据指定的排序规则对数据进行排序
        val list2 = List(
            (1, 2),(3,3),(2,1), (3,5),(3,4)
        )

        //println(list2.sortBy(t => t)(Ordering.Tuple2(Ordering.Int, Ordering.Int.reverse)))

        val userList = List(
            User("zhangsan", 30),
            User("lisi", 30),
            User("wangwu", 30),
            User("zhangsan", 20)
        )

//        val sortList = userList.sortBy(
//            user => {
//                (user.name, user.age)
//            }
//        )(Ordering.Tuple2(Ordering.String, Ordering.Int.reverse))
//        println(sortList)
        // 自定义排序
        val sortList = userList.sortWith(
            ( leftUser, rightUser ) => {
                // 返回boolean类型的值
                //leftUser.name < rightUser.name // 升序
                //leftUser.name > rightUser.name // 降序
                if ( leftUser.name < rightUser.name ) {
                    true
                } else if ( leftUser.name == rightUser.name ) {
                    leftUser.age < rightUser.age
                } else {
                    false
                }
            }
        )
        println(sortList)

    }
    class User {
        var name : String = _
        var age : Int = _

        override def toString: String = {
            s"User[${name}, ${age}]"
        }
    }
    object User {
        def apply( name:String, age : Int ): User = {
            val user = new User()
            user.name = name
            user.age = age
            user
        }
    }
}
