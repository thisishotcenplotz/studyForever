package com.hotcenplotz.chapter17.observerpattern.observer_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-29 06:09 
 * @description:
 * */
trait Subject {
    def register(o:ObjectServer):Unit
    def remove(o:ObjectServer):Unit
    def notifyObserver(): Unit
}
