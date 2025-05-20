package com.hotcenplotz.chapter12

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-21 06:13 
 * @description:
 * */
object Demo08_ {
    def main(args: Array[String]): Unit = {
        val names:String = "Alice,Bob,Thomas"
        
        names match {
            case Names(first,second,third) => println(s"$first ==> $second ==> $third")
            case _ => println("nothing")
        }
    }
}

object Names {
    
    def unapplySeq(str:String):Option[Seq[String]] = {
        if(str.contains(",")) Some(str.split(","))
        else None
    }
}
