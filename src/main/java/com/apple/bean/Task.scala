package com.apple.bean
// 类需要序列化
class Task extends Serializable {

    var start = 0
    var end = 0
    var logic : (Int, Int)=>Unit = null

    // 计算
    def compute(): Unit = {
        logic(start, end)
    }
}
