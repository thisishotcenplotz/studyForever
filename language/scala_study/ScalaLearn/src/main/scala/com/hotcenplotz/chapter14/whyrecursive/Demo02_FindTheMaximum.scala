package com.hotcenplotz.chapter14.whyrecursive

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 10:56 
 * @description:
 * */
object Demo02_FindTheMaximum {
    def main(args: Array[String]): Unit = {
        
        // Bad Demo
        def findTheMax(xs:List[Int]):Int = {
            if (xs.isEmpty)
                throw new NoSuchElementException("Empty list has not maximum...")
            if (xs.size == 1)
                xs.head
            else
                if(xs.head > findTheMax(xs.tail)) xs.head else findTheMax(xs.tail)
        }
        
        // println(findTheMax((1 to 100).toList)) // vali vali bad~
        
        def findMax(xs:List[Int]):Option[Int]= xs match {
            case Nil => None
            case head:: Nil => Some(head)
            case head::tail =>
                findMax(tail).map(tailMax => if (head > tailMax) head else tailMax)
        }
        
        // ok~ but still bad.
        println(findMax((1 to 100).toList))
    }
}
