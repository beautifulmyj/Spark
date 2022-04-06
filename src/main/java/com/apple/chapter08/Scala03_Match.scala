package com.apple.chapter08

object Scala03_Match {

    def main(args: Array[String]): Unit = {

        // 匹配常量
        def describe(x: Any) = {
            x match {
                case 5 => "Int five"
                case "hello" => "String hello"
                case true => "Boolean true"
                case '+' => "Char +"
            }
        }

        //println(describe(5))

        // 匹配类型
        // scala在模式匹配中，匹配类型时，不考虑泛型的。
        // 数组类型是一种特殊的类型给，需要区别对待。
        def describe1(x: Any) = {
            x match {
                case i: Int => i + 1
                case s: String => "String hello"
                case m: List[Int] => "List"
                case c: Array[Int] => "Array[Int]"
                case someThing => "something else " + someThing
            }
        }

        // Array[Int] => int[]
        // List[User] => List<User>

        println(describe1(List("a","b", "c")))
    }
}
