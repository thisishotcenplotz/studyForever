package com.hotcenplotz

import java.io.{File, FileOutputStream}
import scala.io.{BufferedSource, Source}


/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 12:15 
 * @description:
 * */
object Temp {
    def main(args: Array[String]): Unit = {
        case class Duration(ts: String) {
            val hh: BigInt = ts.split(":")(0).toLong
            val mm: Int = ts.split(":")(1).toInt
            
            def add(another: Duration): Duration = {
                val mmHandle = if ((another.mm + this.mm) > 60) (1, (another.mm + this.mm) % 60) else (0, (another.mm + this.mm))
                val hhHandle = this.hh + another.hh + mmHandle._1
                val newMM: String = mmHandle._2.toString.reverse.padTo(2, '0').reverse
                
                Duration(s"${hhHandle.toString}:${newMM}")
            }
            
            override def toString: String = s"$hh:$mm"
        }
        val data: BufferedSource = Source.fromFile("src/main/scala/com/hotcenplotz/content.txt", "utf-8")
        val results: Iterator[(String, String, String,Duration)] = data.getLines().map { line =>
            val row: Array[String] = line.split("->")
            val index: String = row(0).strip()
            val name: String = row(1).strip()
            val duration: String = row(2).strip()
            (index, name, duration,Duration(duration))
        }.scanLeft(("Index", "Contest", "Duration",Duration("0:00")))((a, b) => (b._1, b._2, b._3,b._4.add(a._4)))
        
        val output: FileOutputStream = new FileOutputStream(new File("course.txt"),true)
        
        results.foreach(line => output.write((line.toString() + "\n").getBytes))
        
        output.close()
        data.close()
        
    }
}


