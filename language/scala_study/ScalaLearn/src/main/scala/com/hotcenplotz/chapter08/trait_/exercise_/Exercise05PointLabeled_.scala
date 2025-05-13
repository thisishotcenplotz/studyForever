package com.hotcenplotz.chapter08.trait_.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 08:04 
 * @description: */
class Exercise05PointLabeled_(
    val tag: String, x: Double, y: Double
) extends Exercise05Point_(x, y) {
    override def toString: String = s"$tag ($x,$y)"
}

object Exercise05PointLabeled_ {
    def apply(tag: String, x: Double, y: Double): Exercise05PointLabeled_ = new Exercise05PointLabeled_(tag, x, y)
}
