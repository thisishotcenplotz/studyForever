package com.hotcenplotz

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-01 08:20 
 * @description: Revisiting Scala For the Second Time.
 */


object Main {
  def main(args: Array[String]): Unit = {
    hello()
  }

  def hello():Unit = {
    (1 to 100).foreach(_ => println("Hello Scala again!"))
  }

  /**
   * 第一阶段：基础语法与核心特性（1-2个月）
   * 1. 《Programming in Scala》（第五版）
   * 作者：Martin Odersky（Scala创始人）
   *
   * 亮点：
   *
   * 全面覆盖Scala 2.13核心语法
   *
   * 包含OOP与FP基础融合实践
   *
   * 每章结尾的"深入理解"专栏解析语言设计思想
   *
   * 适用场景：构建扎实的语法基础，理解trait、case class等核心概念
   *
   * 2. 《Scala for the Impatient》（第二版）
   * 作者：Cay S. Horstmann
   *
   * 亮点：
   *
   * 快速实践导向，适合有编程经验者
   *
   * 包含大量简洁示例（如用foldLeft实现复杂聚合）
   */
}
