package com.hotcenplotz.chapter13

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-22 20:55 
 * @description:
 * */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        // 结论：可以实现功能，但是太麻烦。由此引出偏函数
        val list: List[Any] = List(1, 2, 3, 4, 5, 1.2, "abc")
        list.filter(e => e.isInstanceOf[Int]).map(_.asInstanceOf[Int] + 1).foreach(println)
        list.map { case x: Int => x + 1
        case _ =>
        }.filter(_ != ()).foreach(println)
        
        // 使用偏函数
        // 表示偏函数接收的类型是Any，返回的类型是Int类型
        // def isDefinedAt(x: Any): Boolean 如果返回true，就会去调用apply方法，构建对象实例，如果是false 就过滤
        
        val partialFunc: PartialFunction[Any, Int] = new PartialFunction[Any, Int] {
            override def isDefinedAt(x: Any): Boolean = x.isInstanceOf[Int]
            
            override def apply(v1: Any): Int = v1.asInstanceOf[Int] + 1
        }
        
        // 如果是使用偏函数，则不能使用map，而是使用collect
        list.collect(partialFunc).foreach(println)
        
        // 简化形式
        list.collect { case i: Int => i + 1
        case j: Double => (j * 2).toInt
        case k: Float => (k * 3).toInt
        }.foreach(println)
        
        //
    }
}
