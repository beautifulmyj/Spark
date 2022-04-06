package com.apple.chapter07

object Scala04_Collection_Map {
    def main(args: Array[String]): Unit = {

        // TODO 集合 - Map
        // KV 键值对，无序，K不能重复
        // java ： 键值对 JDK1.7 (Entry) JDK1.8(Node)
        // scala : 键值对 ， Key -> Value
        // 默认情况下，scala提供的集合是不可变的。
        val map = Map("a"->1, "b"->2, "c"->3, "a"->4,"e"->2,"f"->6)

        println(map)

    }

}
