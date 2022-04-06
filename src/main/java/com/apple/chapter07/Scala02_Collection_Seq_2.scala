package com.apple.chapter07

import scala.collection.mutable.ListBuffer

object Scala02_Collection_Seq_2 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - Seq - 可变
        val buffer = new ListBuffer[String]()
        val buffer1 = ListBuffer(1,2,3,4)

//        buffer1.append()
//        buffer1.appendAll()
//        buffer1.update()
//        buffer1.insert()
//        buffer1.remove()
//
//        buffer1.foreach()
//        buffer1.mkString()

        buffer1.-=(3)
        buffer1.-(3)

    }

}
