package com.iamhotcenplotz.www.chapter05

object  WhileLoop_ {
  def exercise01(): Unit = {
    var i: Int = 0

    while (i <= 100) {
      println(s"${i}")
      i += 1
    }
  }

  def doWhile(): Unit = {
    var i: Int = 0

    do {
      println(i)
      i += 1
    } while (i < 100)


  }

  def main(args: Array[String]): Unit = {
    exercise01()
    doWhile()

    val aList: List[String] = List("Hi", "How are you")
    println(
      aList.map(i => {
        s"${i} ${i}"
      }).map(j => s"${j} ~ ")
        .mkString
    )
  }

}
