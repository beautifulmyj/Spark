package com.apple.chapter12

import scala.util.matching.Regex

object Scala03_Reg {

    def main(args: Array[String]): Unit = {

        // TODO - 正则表达式 - 手机号码验证
        // 1. 全数字
        // 2. 长度限制 ： 11

        val r: Regex = "^\\d{11}$".r
        // 使用规则
        val s = "12345678901"
        val maybeString: Option[String] = r.findFirstIn(s)
        if ( maybeString.isEmpty ) {
            println("字符串["+s+"]不符合规则 : " + r)
        } else {
            println("字符串["+s+"]符合规则 : " + r)
        }
    }
}
