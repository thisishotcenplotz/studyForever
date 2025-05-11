package com.hotcenplotz.chapter07.package_.visit

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-11 06:43 
 * @description: Scala包的可见性 */
class TestVisit {
    def main(args: Array[String]): Unit = {
        val person: TestPerson = new TestPerson
        println(person.age)
    }
}

class clerk {
    var name: String = "jack"
    protected var age: Int = 10
    private var sal: Double = 9999.9
    
    def showInfo(): Unit = {
        println(s"name $name  sal:$sal")
    }
}

object clerk {
    def test(c: clerk): Unit = {
        println(s"test() name = ${c.showInfo()}")
    }
}

class TestPerson {
    // 这是限制了只有类内部和伴生对象中访问
    private val name: String = "zhang san"
    
    // private[visit] : 此时 age 属性仍然是私有的，但是在visit包即子包下也可以使用这个属性
    // 相当于扩大了访问烦我
    private[visit] val age: Int = 10
    
}