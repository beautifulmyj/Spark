package com.apple.playground

import org.apache.spark.sql.Row

object Play001 {
  def main(args: Array[String]): Unit = {
    def extractFields: Seq[Row] => Seq[(String, Int)] = {
      (rows: Seq[Row]) => rows.map(row => (row.getString(2), row.getInt(4))).toSeq
    }

//    val name = "myj";
//    val result = if (name == "myj") {
//      "maoyanjiao"
//    } else if (name == "lss") {
//      "lisusu"
//    } else {
//      "yangjiayi"
//    }
//
//    println(result)
//
//    println(calc(13, 10, add))
//    println(calc(13, 10, minus))

    val myMap = Map('a' -> 1, 'b' -> 2, 'c' -> 3)
    println(myMap('a'))
  }

  def calc(x: Int, y: Int, f: (Int, Int) => Int): Int = {
    f(x,y)
  }

  def add(x: Int, y: Int): Int = x + y

  def minus(x: Int,y : Int): Int = x - y
}