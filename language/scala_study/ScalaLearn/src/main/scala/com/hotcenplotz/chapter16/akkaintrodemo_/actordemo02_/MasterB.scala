package com.hotcenplotz.chapter16.akkaintrodemo_.actordemo02_

import akka.actor.Actor

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 11:28 
 * @description:
 * */
class MasterB extends Actor {
    private var cnt: Int = 0
    
    override def receive: Receive = {
        case "我打！" => {
            println(s"乔峰：挺猛！看我降龙十八掌！$cnt")
            cnt += 1
            Thread.sleep(100)
            sender() ! "我打！"
            
        }
        case "不打了" => {
            println("乔峰：小样,这次就饶了你！")
            context.stop(sender())
            context.stop(self)
            context.system.terminate()
        }
    }
}
