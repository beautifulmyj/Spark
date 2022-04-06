package com.apple.chapter06

object Scala11_Object_Interface_4 {

    def main(args: Array[String]): Unit = {

        val mysql = new MySQL
        mysql.oper()
    }
    // 钻石问题
    // 类的多继承问题
    // scala中特质也存在钻石问题，但是采用了一张功能叠加的方式来实现。

    // 如果一个类混入了多个特质，那么特质的初始化顺序为从前到后，从左到右
    // 特质中的super表示的是上一个，而不是上一级
    // 特质中功能叠加的调用顺序为从后往前，从右向左
    // 如果想要改变叠加顺序，可以更改super的指向
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
    trait Log extends Operate {
        override def oper(): Unit = {
            print("向日志文件中")
            super[Operate].oper()
        }
    }

    // 向日志文件中向数据库中操作数据...
    // Operate => DB => Log
    class MySQL extends DB with Log{

    }
}

