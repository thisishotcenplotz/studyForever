package com.hotcenplotz.chapter16.exercise_.server

import akka.actor.{Actor, ActorRef, ActorSystem, ExtendedActorSystem, Props}
import com.hotcenplotz.chapter16.exercise_.common.{ClientMessage, ServerMessage, UtilsTs}
import com.typesafe.config.{Config, ConfigFactory}


/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 15:24 
 * @description:
 * */
class YellowServer extends Actor with UtilsTs {
    
    private def reply(msg: String): String = s"[${now()}] - [客服]:$msg"
    
    override def receive: Receive = {
        case "start" => println(reply("小黄鸡客服已上线"))
        case ClientMessage(msg) => {
            println(s"[客户]:$msg")
            val str: String = msg match {
                case "1" => "今天天气不错"
                case "2" => "Scala 是世界上最伟大的语言"
                case "3" => "做人要遵循：不球行要虚心的原则"
                case "4" => "对于那种不球行还不虚心的人，我们要远离，不要消耗能量去处理那些人的负面能量"
                case _ => "无他，唯手熟尔！"
            }
            
            sender() ! ServerMessage(str)
        }
        case other => println(s"收到未知消息:$other")
    }
}

object YellowServer extends App {
    val host = "127.0.0.1"
    val port = 20010
    
    val config: Config = ConfigFactory.parseString(
        s"""
           |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
           |akka.actor.allow-java-serialization = on
           |akka.remote.artery {
           |  transport = tcp
           |  canonical.hostname = "$host"
           |  canonical.port = $port
           |}
           |""".stripMargin)
    
    val serverActorSystem: ActorSystem = ActorSystem("Server", config)
    val yellowServer: ActorRef = serverActorSystem.actorOf(Props[YellowServer], "YellowServer")

    // 启动
    yellowServer ! "start"
}
