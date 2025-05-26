package com.hotcenplotz.chapter16.demoaspark_.common

import scala.beans.BeanProperty

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 19:26 
 * @description:
 * */
// work注册信息
case class RegisteredWorkerInfo(id: String, cpu: Int, ram: Int)

// WorkerInfo，保存在master的HashMap中的hm（该HashMap用于管理worker）
// 将来这个WorkerInfo会扩展 （比如增加worker上一次的心跳事件）
class WorkerInfo(val id: String, val cpu: Int, val ram: Int) {
    var lastHeartBeat: Long = System.currentTimeMillis()
}

// 当worker注册成功，服务器返回一个RegisteredWorkerInfo对象
case object RegisteredWorkerInfo

// worker每隔一定时间由定时器发给自己的一个消息
case object SendHeartBeat

// worker每隔一定时间由定时器触发，向master发送的协议消息
case class heartBeat(id: String)


// master给自己发送一个触发检查超时worker信息
case object StartTimeOutWorker

// master给自己发消息，检测worker，对于心跳超时的
case object RemoveTimeOutWorker