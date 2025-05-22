package com.hotcenplotz.chapter12.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-22 07:35 
 * @description:
 * */
case class Bundle(
    description: String, discount: Double, item: Item*
) extends Item
