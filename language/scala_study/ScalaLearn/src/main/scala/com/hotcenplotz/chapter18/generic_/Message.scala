package com.hotcenplotz.chapter18.generic_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-30 07:50 
 * @description:
 * */
abstract class Message[T](s:T) {
    
    def getMessage: T = s
}


class IntMessage[Int](v:Int) extends Message(v) {}

class StringMessage[String](msg:String) extends Message(msg) {}