package com.apple.chapter08

object Scala02_Match {

    def main(args: Array[String]): Unit = {

        // TODO scala中的模式匹配的语法类似于java的switch语法
        var a: Int = 10
        var b: Int = 20
        var operator: Char = 'd'
        // 模式匹配中不需要使用break
        // 满足case条件时，会执行=>右边的内容，但是默认情况下，省略了大括号
        // 所以代码执行完后，match自动跳出
        // 下划线在模式匹配中表示任意值
        // 下划线的分支判断一般都是放置在最后

        // 如果所有的分支都不满足条件，并且没有下划线的分支
        // 那么会出现错误：scala.MatchError
        var result = operator match {
            //case _ => "illegal"
            case '+' => {
                a + b
            }
            case '-' => a - b
            case '*' => a * b
            case '/' => a / b

        }
        println(result)
    }
}
