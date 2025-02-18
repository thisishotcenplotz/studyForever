package com.iamhotcenplotz.chapter13.timestamp_;

import java.util.Calendar;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Calendar_ {
    public static void main(String[] args) {

        // Calendar is an abstract object and has protected constructor
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar);

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
    }
}
