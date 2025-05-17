package com.hotcenplotz.chapter10.queue_

import scala.collection.mutable

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-17 09:45 
 * @description: 队列演示
 * */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        val queue: mutable.Queue[Int] = new mutable.Queue[Int]
        println(queue)
        
        // 添加元素
        queue += 20
        println(queue)
        queue ++= List(1,2,3) // 把1，2，3 加到queue末尾
        println(queue)
        
        // queue += List(1,2,3) // 将List(1,2,3) 作为一个元素加入队列。不行new mutable.Queue[Int]
        
        // 出队列
        println(queue.dequeue())
        println(queue)
        
        // 入队列
        queue.enqueue(666)
        queue.enqueue(666)
        queue.enqueue(666)
        println(queue)
        
        // 查询 但不取出
        println(queue.head)
        println(queue.last)
        println(queue.tail) // 返回除第一个之外的所有元素 是一个队列
        println(queue.tail.tail.tail)
        
    }
}
