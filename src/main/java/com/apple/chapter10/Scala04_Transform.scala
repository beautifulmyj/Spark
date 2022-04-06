package com.apple.chapter10

object Scala04_Transform {

    def main(args: Array[String]): Unit = {

        // 隐式参数
        // OCP
        def reg( implicit password:String = "000000" ): Unit = {
            println("默认密码为：" + password)
        }

        // 隐式变量
        implicit val pswd = "123123"
        //implicit val name = "lisi"

        // 如果使用隐式参数，那么参数列表是需要省略
        reg
        // 如果不省略参数列表，那么表示不使用隐式转换，如果有参数默认值，那么就使用默认值
        reg()
        // 如果传值，那么默认值就不起作用
        reg("zhangsan")

        //List(1,4,3,2).sortBy(num=>num)(Ordering.Int.reverse)
    }
}
