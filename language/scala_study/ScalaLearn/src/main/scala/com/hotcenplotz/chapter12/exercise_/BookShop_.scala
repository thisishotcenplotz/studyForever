package com.hotcenplotz.chapter12.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-22 07:38 
 * @description:
 * */
object BookShop_ {
    def main(args: Array[String]): Unit = {
        // an order demo
        val anOrder: Bundle = Bundle("书籍", 10, Book("漫画", 40), Bundle("文学作品", 20, Book("阳关", 80), Book("围城", 30),Book("天龙八部", 100)))
        
        // match demo -> get 漫画
        val cartoonDesc: String = anOrder match {
            case Bundle(_, _, Book(description, _), _*) => description
        }
        println(cartoonDesc)
        
        // 动态变量
        // 返回Book 和 Item*
        val books: (Book, Seq[Item]) = anOrder match {
            case Bundle(_, _, cartoon@Book(description, price), rest@_*) => (cartoon, rest)
        }
        
        println(books)
        
        // 计算应付金额
        println(orderProcess(anOrder))
    }
    
    def orderProcess(item:Item):Double = {
        item match {
            case Book(_, price) => price
            case Bundle(_, discount, items@_*) => items.map(orderProcess).sum - discount
        }
    }
}
