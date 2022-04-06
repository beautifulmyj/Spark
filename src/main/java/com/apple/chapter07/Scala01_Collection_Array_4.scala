package com.apple.chapter07

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Scala01_Collection_Array_4 {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - 数组 - Array - 可变
        val array = Array(1,2,3,4)
        val buffer = ArrayBuffer(1,2,3,4)
        val buffer1 = ArrayBuffer(5,6,7,8)
//        buffer.+=(5)
//        buffer.+:(5)
//        buffer.++(buffer1)
//        buffer.++=(buffer1)
        println("****************")
        // 多维数组
        // 矩阵
        // [1,2,3]
        // [4,5,6]
        // [7,8,9]
        var myMatrix = Array.ofDim[Int](3,3)
        //myMatrix.foreach(list=>list.foreach(println))

        // 可变集合和不可变集合互相转换
        val buffer2: mutable.Buffer[Int] = array.toBuffer
        val array4: Array[Int] = buffer.toArray

        // 合并数组
        //Array.concat(buffer)
        val arr6 = Array.concat(array, array4)
        //println(arr6.mkString(","))

        //
        val ints: Array[Int] = Array.range(0, 20)

        // 创建并填充指定数量的数组
        val arr8:Array[Int] = Array.fill[Int](5)(-1)
        arr8.foreach(println)


    }

}
