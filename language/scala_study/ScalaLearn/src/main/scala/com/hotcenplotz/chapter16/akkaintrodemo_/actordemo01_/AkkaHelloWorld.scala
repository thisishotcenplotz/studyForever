package com.hotcenplotz.chapter16.akkaintrodemo_.actordemo01_

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 10:27 
 * @description: Akka 入门示例代码
 * */

// 说明
// 1.当我们继承Actor后，就是一个Actor，核心方法receive方法得重写
class AkkaHelloWorld extends Actor{
    
    // 说明：
    // 1. receive 这个方法会被该Actor的Mailbox（实现了runnable接口）调用
    // 2. 当该Actor的mailbox接收到消息时，就会调用receive
    // 3. receive是一个偏函数
    override def receive: Receive = {
        case "Hello" => println("收到Hello，回应:Hello too..")
        case "Ok" => println("收到Ok，回应：Ok~~~")
        case "exist" => {
            println("接收到退出指令")
            
            context.stop(self) // 停止当前Actor的邮箱
            context.system.terminate() // 退出ActorSystem
        }
        case _ => println("匹配不到")
    }
}

object AkkaHelloWorldDemo {

    // 1. 先创建一个ActorSystem，专门用于创建Actor
    private val actorFactory: ActorSystem = ActorSystem("ActorFactory")
    
    // 2. 创建一个Actor的同时，返回Actor的ActorRef
    //    说明：
    //        2.1： actorFactory.actorOf(Props[AkkaHelloWorld]) 这句话创建了一个AkkaHelloWorld实例，使用了反射
    //        2.2： helloWorldActor 给actor取了个名字
    //        2.3： helloWorldActor: ActorRef 就是Props[AkkaHelloWorld] 的ActorRef
    //        2.4:  创建的 AkkaHelloWorld 实例被ActorSystem接管
    private val helloWorldActorRef: ActorRef = actorFactory.actorOf(Props[AkkaHelloWorld])
    
    def main(args: Array[String]): Unit = {
        // 给AkkaHelloWorld的邮箱发消息
        helloWorldActorRef ! "Ok"
        helloWorldActorRef ! "Hello"
        helloWorldActorRef ! "Hello"
        helloWorldActorRef ! "Hello"
        helloWorldActorRef ! "Hello"
        helloWorldActorRef ! "Hello"
        helloWorldActorRef ! "Hello"
        helloWorldActorRef ! "Hello"
        helloWorldActorRef ! "~"
        helloWorldActorRef ! "~"
        
        // 退出ActorSystem
        helloWorldActorRef ! "exist"
        
    }
}

