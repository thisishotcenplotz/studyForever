package com.hotcenplotz.chapter15.model

import scala.beans.BeanProperty

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 14:32 
 * @description:
 * */
case class Customer(
    var id: Int, var name: String, var gender: Char, var age: Short, var tel: String, var email: String
){
    override def toString: String = {
        s"""
           |+++++++++++++++++++++++++++++++++
           |+ id     : $id
           |+ name   : $name
           |+ gender : $gender
           |+ age    : $age
           |+ tel    : $tel
           |+ email  : $email
           |+++++++++++++++++++++++++++++++++
           |""".stripMargin
    }
    
    def displayString:String = {
        s"$id\t\t$name\t\t$gender\t\t$age\t\t$tel\t\t$email"
    }
    
}
