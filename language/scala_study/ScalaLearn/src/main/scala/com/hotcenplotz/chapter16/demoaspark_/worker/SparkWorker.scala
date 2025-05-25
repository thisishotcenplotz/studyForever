package com.hotcenplotz.chapter16.demoaspark_.worker

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.hotcenplotz.chapter16.demoaspark_.common.Utils
import com.typesafe.config.Config

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 19:05 
 * @description:
 * */
class SparkWorker(
    masterName: String, masterHost: String, masterPort: String
) extends Actor {
    var masterProxy: ActorSelection = _
    
    override def preStart(): Unit = {
        masterProxy = context.actorSelection(s"akka://$masterName@$masterHost:$masterPort/user/SparkMaster-01")
    }
    
    override def receive: Receive = {
        case "start" => {
            println("Worker service Start..")
        }
    }
}

object SparkWorker {
    def main(args: Array[String]): Unit = {
        val masterHost = "127.0.0.1"
        val masterPort = "10005"
        
        val workAkkaConf: Config = Utils.genAkkaConf("127.0.0.1", "10010")
        
        // 创建ActorSystem
        val workerSystem: ActorSystem = ActorSystem("SparkWorker01", workAkkaConf)
        
        // 创建代理
        val work: ActorRef = workerSystem.actorOf(Props(new SparkWorker(masterName = "SparkMaster", masterHost = masterHost, masterPort = masterPort)))
        
        //启动
        work.tell("start",work)
    }
}
