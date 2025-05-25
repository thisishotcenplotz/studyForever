package com.hotcenplotz.chapter16.akkaintrodemo_.actordemo02_

import akka.actor.{ActorRef, ActorSystem, Props}



/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 11:28 
 * @description:
 * */


object MasterGame extends App {
    // 创建ActorSystem
    val factory: ActorSystem = ActorSystem("actorFactory")
    
    // 创建B代理
    val qiaofeng: ActorRef = factory.actorOf(Props[MasterB], "qiaofeng")
    
    // 创建A代理
    val huangfeihong: ActorRef = factory.actorOf(Props(new MasterA(qiaofeng)))
    
    // 动手
    huangfeihong ! "start"
}
