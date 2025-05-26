package com.hotcenplotz.chapter14.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-26 21:59 
 * @description:
 * */
object WordCount {
    def main(args: Array[String]): Unit = {
        val text: String =
            """
              |特朗普在新泽西州登上“空军一号”专机前对记者表示，他同意财政部长斯科特·贝森特关于“美国不一定需要蓬勃发展的纺织业”的言论。特朗普说：“我们的目标不是生产运动鞋和T恤。我们要制造军事装备、要制造尖端科技产品、要发展人工智能。”
              |
              |　　据报道，特朗普进一步表明，他对生产T恤和袜子没兴趣，这些完全可以在其他地方生产。美国要聚焦芯片、计算机、坦克、轮船等领域。
              |
              |　　特朗普23日再次发表强硬的贸易政策言论，他建议从6月1日开始对来自欧盟的商品征收50%的关税，并警告苹果公司可能对所有进口iPhone征收25%消费关税。（王雨晴）
              |""".stripMargin
        
        val result: List[(String, Int)] = text.strip().split("").map((_, 1)).groupBy(_._1).map(x => (x._1, x._2.size)).toList.sortBy(_._2).reverse
        println(result)
    }
}
