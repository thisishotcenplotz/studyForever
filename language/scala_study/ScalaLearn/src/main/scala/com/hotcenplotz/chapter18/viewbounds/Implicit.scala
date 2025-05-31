package com.hotcenplotz.chapter18.viewbounds

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-31 15:39 
 * @description:
 * */
object Implicit {
    implicit def personToOrderedPerson(p:PersonManual): Ordered[PersonManual] = new Ordered[PersonManual] {
        override def compare(that: PersonManual): Int = p.age - that.age
    }
}
