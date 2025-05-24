package com.hotcenplotz.chapter14.whyrecursive

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 11:29 
 * @description: Fibonacci
 * */
object Demo04_ {
    def main(args: Array[String]): Unit = {
        //
        var cnt: BigInt = BigInt(0)
        
        // 10 -> 13529
        // 11 -> 21891
        // 递归的次数呈现指数增长。
        // 这里就需要优化了
        // 优化策略：
        // 1. 该递归为迭代
        // 2. 减少递归次数
        def fibo(n: BigInt): BigInt = {
            cnt += 1
            if (n == 1 || n == 2) 1 else fibo(n - 1) + fibo(n - 2)
        }
        
        
        def optimizedFibo(n: Int): BigInt = {
            def loop(pre: BigInt, cur: BigInt, step: Int): BigInt = {
                if (step == n) cur else loop(cur, cur + pre, step + 1)
            }
            
            n match {
                case 0 => 0
                case 1 => 1
                case _ => loop(0, 1, 1)
            }
        }
        
        println(optimizedFibo(100))
    }
}
