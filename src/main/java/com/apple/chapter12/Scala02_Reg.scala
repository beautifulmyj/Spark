package com.apple.chapter12

import scala.util.matching.Regex

object Scala02_Reg {

    def main(args: Array[String]): Unit = {

        // TODO - 正则表达式
        // 模式匹配主要在匹配数据的规则
        // 正则表达式在匹配字符串的规则

        // 正则表达式
        // 声明规则
        val r: Regex = "^zn$".r
        // 使用规则
        val s = "zhangsan"
        val maybeString: Option[String] = r.findFirstIn(s)
        if ( maybeString.isEmpty ) {
            println("字符串["+s+"]不符合规则 : " + r)
        } else {
            println("字符串["+s+"]符合规则 : " + r)
        }
    }
}
