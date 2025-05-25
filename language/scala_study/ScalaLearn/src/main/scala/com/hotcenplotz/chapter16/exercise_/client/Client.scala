package com.hotcenplotz.chapter16.exercise_.client

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.hotcenplotz.chapter16.exercise_.common.{ClientMessage, ServerMessage, UtilsTs}
import com.typesafe.config.{Config, ConfigFactory}

import scala.io.StdIn

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-05-25 15:44
 * @description:
 * */
class Client(
    serverHost: String, serverPort: String
) extends Actor with UtilsTs {
    // 定义服务器的引用
    var serverActorRef: ActorSelection = _
    
    // 在Actor中有一个方法PreStart方法，他会在actor运行前执行
    // 通常将初始化的工作放在PreStart方法中
    
    override def preStart(): Unit = {
        println("preStart() ...")
        serverActorRef = context.actorSelection(s"akka://Server@${serverHost}:$serverPort/user/YellowServer")
        println("serverActorRef=" + serverActorRef)
    }
    
    def reply(msg: String) = s"[${now()}] - [用户]: $msg"
    
    override def receive: Receive = {
        case "start" => println(reply("客户端已经启动"))
        case input: String => serverActorRef.tell(ClientMessage(input),self)
        case ServerMessage(msg) => println(msg)
    }
}

object Client extends App {
    val clientHost = "127.0.0.1"
    val clientPort = 30010
    val ServerHost = "127.0.0.1"
    val ServerPort = 20010
    
    val config: Config = ConfigFactory.parseString(
        s"""
           |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
           |akka.actor.allow-java-serialization = on
           |akka.remote.artery {
           |  transport = tcp
           |  canonical.hostname = "$clientHost"
           |  canonical.port = $clientPort
           |}
           |""".stripMargin)
    
    val clientActorSystem: ActorSystem = ActorSystem("Client", config)
    
    val clientRef: ActorRef = clientActorSystem.actorOf(Props(new Client(ServerHost, ServerPort.toString)), "YellowClient")
    
    clientRef ! "start"
    
    
    
    while (true) {
        print("请输入：")
        val input: String = StdIn.readLine()
        if (input != null && input.nonEmpty) clientRef ! input
    }
}
