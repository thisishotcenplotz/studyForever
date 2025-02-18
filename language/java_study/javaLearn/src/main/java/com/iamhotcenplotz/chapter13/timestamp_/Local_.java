package com.iamhotcenplotz.chapter13.timestamp_;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Local_ {
    public static void main(String[] args) {
        // LocalDate  年月日
        // LocalTime 时分秒
        // LocalDateTime 年月日时分秒

        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());

        System.out.println(now.plusDays(1));
        System.out.println(now.plusHours(1));
        System.out.println(now.plusMinutes(1));
        System.out.println(now.plusSeconds(1));


        //format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(formatter.format(now));

        System.out.println(now.format(formatter));


        // Instant -> Date
        Instant instant = Instant.now();
        System.out.println(Date.from(instant));
        System.out.println(Date.from(instant).toInstant());


    }
}
