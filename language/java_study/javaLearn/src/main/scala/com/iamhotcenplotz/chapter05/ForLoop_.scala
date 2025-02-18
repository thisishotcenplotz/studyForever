package com.iamhotcenplotz.chapter05

object ForLoop_ {
  def forLoop():Unit = {
    (1 to 100).foreach(i => println(s"${i}: Hello World"))
  }
  def forLoop2():Unit = {
    (1 to 10).foreach(i =>{
      (1 to i).foreach(j => {
        if (i >= j){
          print("*")
        } else {
          print(" ")
        }
      })
      println()
    })
  }


  def main(args: Array[String]): Unit = {
    forLoop()
    forLoop2()
  }

}
