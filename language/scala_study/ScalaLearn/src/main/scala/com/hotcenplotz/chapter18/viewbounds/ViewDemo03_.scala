package com.hotcenplotz.chapter18.viewbounds

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-31 15:34 
 * @description: 自定义隐式转换的视图界定
 * */
object ViewDemo03_ {
    def main(args: Array[String]): Unit = {
        import Implicit._
        val zhangsan: PersonManual = new PersonManual("Zhangsan", 20)
        val lisi: PersonManual = new PersonManual("Lisi", 30)
        
        println(new PersonCompareManual(zhangsan, lisi).greater)
    }
}

class PersonManual(val name:String,val age:Int){
    
    override def toString: String = s"${this.name}   ${this.age}"
}

// 说明：
// 1. T <% Ordered[T]  表示 T 是 Ordered 的子类型
class PersonCompareManual[T <% Ordered[T]](zhangsan:T,lisi:T) {
    def greater:T = if(zhangsan > lisi) zhangsan else lisi
    def greater2:T = if(zhangsan.compareTo(lisi) > 0) zhangsan else lisi
}

