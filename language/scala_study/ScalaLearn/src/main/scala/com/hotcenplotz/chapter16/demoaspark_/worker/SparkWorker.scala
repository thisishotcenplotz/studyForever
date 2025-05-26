package com.hotcenplotz.chapter16.demoaspark_.worker

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.hotcenplotz.chapter16.demoaspark_.common.{RegisteredWorkerInfo, SendHeartBeat, Utils, heartBeat}
import com.typesafe.config.Config

import scala.concurrent.duration._
import scala.language.postfixOps

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
    lazy val id: String = java.util.UUID.randomUUID().toString
    
    override def preStart(): Unit = {
        masterProxy = context.actorSelection(s"akka://$masterName@$masterHost:$masterPort/user/$masterName")
    }
    
    override def receive: Receive = {
        case "start" => {
            println("Worker service Start..")
            masterProxy.tell(RegisteredWorkerInfo(id = id, cpu = 16, ram = 1024 * 16), self)
        }
        case RegisteredWorkerInfo => {
            println(s"Worker Id:[$id] 注册成功")
            
            // 注册成功后，就定义一个定时器，每隔一段时间，发送SendHeartBeat给自己
            // 0 millis 表示立即触发 不延迟
            // 3000 millis 表示每隔3秒执行一次
            // self 表示发送给自己
            // SendHeartBeat 发送的内容
            import context.dispatcher
            context.system.scheduler.scheduleAtFixedRate(0 millis, 3000 millis, self, SendHeartBeat)
        }
        case SendHeartBeat => {
            masterProxy.tell(heartBeat(id), self)
            println(s"worker[$id] 给 master 发送心跳")
        }
    }
}

object SparkWorker {
    def main(args: Array[String]): Unit = {
        if (args.length != 6) {
            println(s"请输入 workerHost,workerPort,workerName,masterHost,masterPort,masterName")
            sys.exit()
        }
        
        val workerHost: String = args(0)
        val workerPort: String = args(1)
        val workerName: String = args(2)
        
        val masterHost: String = args(3)
        val masterPort: String = args(4)
        val masterName: String = args(5)
        
        val workAkkaConf: Config = Utils.genAkkaConf(workerHost, workerPort)
        
        // 创建ActorSystem
        val workerSystem: ActorSystem = ActorSystem("SparkWorker", workAkkaConf)
        
        // 创建代理
        val work: ActorRef = workerSystem.actorOf(
            Props(new SparkWorker(
                masterName = masterName
                , masterHost = masterHost
                , masterPort = masterPort
            ))
            , workerName
        )
        
        //启动
        work.tell("start", work)
    }
}
