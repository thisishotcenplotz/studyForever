package com.hotcenplotz.chapter08.trait_.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 07:13 
 * @description:
 * */


class Exercise02Point_(
    var x: Int = 0, var y: Int = 0
) {}

object Exercise02Point_ {
    def apply(x: Int, y: Int): Exercise02Point_ = new Exercise02Point_(x, y)
}

