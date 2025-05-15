package com.hotcenplotz.chapter09

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-14 21:23 
 * @description:
 * */
object Demo03_ {
    def main(args: Array[String]): Unit = {
        implicit class DBDatabase(val m:MySQLDatabase) {
            def addSuffix(): String = m + " Scala"
        }
        
        val database = new MySQLDatabase
        
        println(database.addSuffix())
    
    }
    
}

class MySQLDatabase {
    def sayOk():Unit = println("ok~")
    
    override def toString: String = "MySQLDatabase"
}
