package com.hotcenplotz.chapter18.contestbounds

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-31 15:54 
 * @description:
 * */
object ContextBoundDemo_ {
    
    // 定义两个person比较的隐式值
    implicit val personCompare = new Ordering[Person] {
        override def compare(x: Person, y: Person): Int = x.age - y.age
    }
    
    
    def main(args: Array[String]): Unit = {
        val zhangsan: Person = new Person("zhangsan", 10)
        val lisi: Person = new Person("lisi", 20)
        
        println(new CompareMethodOne(zhangsan, lisi).greater)
        println(new CompareMethodTwo(zhangsan, lisi).greater)
    }
}

class Person(val name: String, val age: Int) {
    override def toString: String = this.name + " \t" + this.age
}

// 方式1
// 说明：
// 1. [T: Ordering] -> 这是泛型
// 2. (a: T, b: T)  -> 这是形参
// 3. (implicit comparator: Ordering[T]) -> 这是隐式参数
class CompareMethodOne[T: Ordering](a: T, b: T)(implicit comparator: Ordering[T]) {
    def greater: T = if (comparator.compare(a, b) > 0) a else b
    
    def lower: T = if (comparator.compare(a, b) > 0) b else a
}

// 方式2
// 将隐式值写到了类里头
class CompareMethodTwo[T: Ordering](a: T, b: T) {
    // looks bad...
    def greater: T = {
        def f1(implicit c: Ordering[T]): Int = c.compare(a, b)
        
        if (f1 > 0) a else b
    }
}

// 方式3
// 使用implicitly语法糖，最简单（推荐使用）
class CompareMethodThree[T: Ordering](a: T, b: T) {
    def greater: T = {
        // 这句话会获取到上面的隐式值 personCompare
        val comparator: Ordering[T] = implicitly[Ordering[T]]
        
        if (comparator.compare(a, b) > 0) a else b
    }
}