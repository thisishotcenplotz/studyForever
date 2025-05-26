package com.hotcenplotz.chapter16.demoaspark_.master

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.hotcenplotz.chapter16.demoaspark_.common.{RegisteredWorkerInfo, RemoveTimeOutWorker, StartTimeOutWorker, Utils, WorkerInfo, heartBeat}
import com.typesafe.config.Config

import scala.concurrent.duration._
import scala.collection.mutable
import scala.language.postfixOps

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 18:54 
 * @description:
 * */
class SparkMaster extends Actor {
    val workers: mutable.HashMap[String, WorkerInfo] = mutable.HashMap[String, WorkerInfo]()
    
    override def receive: Receive = {
        case "start" => {
            println("SparkMaster service start...")
            
            // 发送检查worker是否超时信息
            self.tell(StartTimeOutWorker, self)
        }
        case RegisteredWorkerInfo(id, cpu, ram) => {
            if (!workers.contains(id)) { // 创建一个WorkerInfo
                workers += ((id, new WorkerInfo(id, cpu, ram)))
                
                // 打印一下当前集群workers 信息
                println(s"当前服务器workers： $workers")
                
                // ；回复一个注册成功
                sender().tell(RegisteredWorkerInfo, self)
            }
        }
        case heartBeat(id) => {
            val l: Long = System.currentTimeMillis()
            workers(id).lastHeartBeat = l
            println(s"worker[$id] is alive at $l")
        }
        case StartTimeOutWorker => {
            println(s"开始定时检测worker心跳任务")
            
            import context.dispatcher;
            
            context.system.scheduler.scheduleAtFixedRate(0 millis, 1000 * 10 millis, self, RemoveTimeOutWorker)
        }
        case RemoveTimeOutWorker => { // 检测心跳超时的worker 并从 Map中移除
            workers.values.filter(w => (System.currentTimeMillis() - w.lastHeartBeat) > 6000).foreach(w => workers.remove(w.id))
            
            println(s"当前有 ${workers.size} 个worker 存活")
        }
    }
}

object SparkMaster {
    
    def main(args: Array[String]): Unit = {
        
        if (args.length != 3) {
            println("请输入 host port sparkMasterActor名字")
            sys.exit()
        }
        
        val host: String = args(0)
        val port: String = args(1)
        val name: String = args(2)
        // 生成akka配置
        val masterAkkaConf: Config = Utils.genAkkaConf(host, port)
        
        // 创建ActorSystem
        val sparkMasterSystem: ActorSystem = ActorSystem("SparkMaster", masterAkkaConf)
        
        // 创建SparkMaster Actor
        val sparkMaster: ActorRef = sparkMasterSystem.actorOf(Props[SparkMaster], s"${name}")
        
        // 启动
        sparkMaster.tell("start", sparkMaster)
    }
}
