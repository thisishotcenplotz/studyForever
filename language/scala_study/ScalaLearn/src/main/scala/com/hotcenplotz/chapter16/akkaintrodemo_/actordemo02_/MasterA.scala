package com.hotcenplotz.chapter16.akkaintrodemo_.actordemo02_

import akka.actor.{Actor, ActorRef}

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 11:28 
 * @description:
 * */

class MasterA(actorRef:ActorRef) extends Actor {
    private var cnt:Int = 0
    
    
    override def receive: Receive = {
        case "start" => {
            println("黄飞鸿出招了！，start ok~")
            self ! "我打！" // 发给自己
        }
        case "我打！" => {
            if(cnt <= 10) {
                // 给B Actor 发消息
                // 这里需要持有B Actor 的Ref
                println(s"黄飞鸿：厉害！看我佛山无影脚 $cnt")
                cnt += 1
                Thread.sleep(100)
                actorRef ! "我打！"
            } else {
                println("黄飞鸿：不打了！没意思！")
                actorRef ! "不打了"
            }
        }
    }
}
