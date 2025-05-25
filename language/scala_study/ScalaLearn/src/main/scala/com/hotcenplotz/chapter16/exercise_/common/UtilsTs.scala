package com.hotcenplotz.chapter16.exercise_.common

import java.text.SimpleDateFormat
import java.util.Date

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-25 15:52 
 * @description:
 * */
trait UtilsTs {
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    
    def now(): String = format.format(new Date())
}
