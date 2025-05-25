package com.hotcenplotz.chapter16.demoaspark_.master

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.hotcenplotz.chapter16.demoaspark_.common.Utils
import com.typesafe.config.Config
import scala.collection.mutable.HashMap

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 18:54 
 * @description:
 * */
class SparkMaster extends Actor {
    
    
    override def receive: Receive = {
        case "start" => println("SparkMaster service start...")
    }
}

object SparkMaster {
    
    def main(args: Array[String]): Unit = {
        val masterAkkaConf: Config = Utils.genAkkaConf("127.0.0.1", "10005")
        
        // 创建ActorSystem
        val sparkMasterSystem: ActorSystem = ActorSystem("SparkMaster", masterAkkaConf)
        
        // 创建SparkMaster Actor
        val sparkMaster: ActorRef = sparkMasterSystem.actorOf(Props[SparkMaster], "SparkMaster-01")
        
        // 启动
        sparkMaster.tell("start", sparkMaster)
    }
}
