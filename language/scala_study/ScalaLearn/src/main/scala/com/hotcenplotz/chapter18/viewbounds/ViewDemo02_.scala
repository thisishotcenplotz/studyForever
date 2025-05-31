package com.hotcenplotz.chapter18.viewbounds

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-31 15:17 
 * @description:
 * */
object ViewDemo02_ {
    def main(args: Array[String]): Unit = {
        val zhangsan: Person = new Person("Zhangsan", 20)
        val lisi: Person = new Person("Lisi", 30)
        
        println(new PersonCompare(zhangsan, lisi).greater)
        
        val aaabbbccc: Cat = new Cat("aaabbbccc")
        val abc: Cat = new Cat("abc")
        println(new PersonCompare(abc, aaabbbccc).greater2)
    }
}

class Cat(val name:String) extends Ordered[Cat] {
    override def compare(that: Cat): Int = this.name.length - that.name.length
    
    override def toString: String = this.name
}


class Person(val name:String,val age:Int) extends Ordered[Person] {
    
    override def compare(that: Person): Int = this.age - that.age
    
    override def toString: String = s"${this.name}   ${this.age}"
}

// 说明：
// 1. T <% Ordered[T]  表示 T 是 Ordered 的子类型
class PersonCompare[T <% Ordered[T]](zhangsan:T,lisi:T) {
    def greater:T = if(zhangsan > lisi) zhangsan else lisi
    def greater2:T = if(zhangsan.compareTo(lisi) > 0) zhangsan else lisi
}
