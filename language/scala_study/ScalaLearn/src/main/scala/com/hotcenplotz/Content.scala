package com.hotcenplotz

import scala.io.Source
import scala.util.matching.Regex

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-01 11:47 
 * @description:
 */


object Content {

    def main(args: Array[String]): Unit = {
        val htmlText = Source.fromFile("src/main/scala/com/hotcenplotz/data.html", "UTF-8").mkString
        // 定义提取整个simple-base-item块的正则
        val itemPattern: Regex = """<div[^>]*class="simple-base-item[^>]*>([\s\S]*?)<\/div>\s*<\/div>\s*<\/div>""".r

        // 定义提取内部详细信息的正则
        val titlePattern: Regex = """title="([^"]+)"""".r
        val titleTextPattern: Regex = """<div class="title-txt">([^<]+)<\/div>""".r
        val durationPattern: Regex = """\d{1,2}:\d{2}""".r

        // 提取所有simple-base-item内容
        val items = itemPattern.findAllMatchIn(htmlText).toList

        items.foreach { m =>
            val itemContent = m.group(1)

            // 提取标题
            val title = titlePattern.findFirstMatchIn(itemContent) match {
                case Some(t) => t.group(0)
                case None => "未找到标题"
            }


            // 提取时长
            val duration = durationPattern.findFirstMatchIn(itemContent) match {
                case Some(d) => d.group(0)
                case None => "未找到时长"
            }

            println(s"$title ---> $duration")
        }

    }

}
