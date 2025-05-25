package com.hotcenplotz.chapter16.demoaspark_.common

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 19:26 
 * @description:
 * */

// work注册信息
case class MessageProtocol(id:String,cpu:Int,ram:Int)

// WorkerInfo，保存在master的HashMap中
class WorkerInfo(val id:String,val cpu:Int,val ram:Int)
case object RegisteredWorkerInfo
