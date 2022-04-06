package com.apple.chapter06

object Scala11_Object_Interface_5 {

    def main(args: Array[String]): Unit = {

        val mysql = new MySQL
        mysql.oper()
    }

    trait Operate {
        def oper(): Unit = {
            println("操作数据...")
        }
    }
    trait DB extends Operate {
        override def oper(): Unit = {
            print("向数据库中")
            super.oper()
        }
    }

    class MySQL extends DB{

    }
}

