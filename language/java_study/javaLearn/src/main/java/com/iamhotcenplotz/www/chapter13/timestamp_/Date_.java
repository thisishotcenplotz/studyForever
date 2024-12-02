package com.iamhotcenplotz.www.chapter13.timestamp_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Date_ {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dt = new Date(); // current system timestamp

        System.out.println(simpleDateFormat.format(dt.getTime()));

        String now = Ts.strTsNow();

        System.out.println(simpleDateFormat.parse(now));
    }
}


class Ts {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String strTsNow(){
        return format.format(new Date().getTime());
    }
}