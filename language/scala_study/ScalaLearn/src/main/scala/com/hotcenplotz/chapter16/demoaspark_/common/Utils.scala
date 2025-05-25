package com.hotcenplotz.chapter16.demoaspark_.common

import com.typesafe.config.{Config, ConfigFactory}


/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 18:55 
 * @description:
 * */
object Utils {
    
    def genAkkaConf(host: String, port: String): Config = {
        ConfigFactory.parseString(
            s"""
               |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
               |akka.actor.allow-java-serialization = on
               |akka.remote.artery {
               |  transport = tcp
               |  canonical.hostname = "$host"
               |  canonical.port = $port
               |}
               |""".stripMargin)
    }
}
