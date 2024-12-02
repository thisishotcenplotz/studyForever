package com.iamhotcenplotz.www.chapter13.large_;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class BigDecimal_ {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("12332123212312312.2323232323");

        System.out.println(bigDecimal.add(new BigDecimal("1123123.2121212312")));
        System.out.println(bigDecimal.subtract(new BigDecimal("1123123.21212312")));
        System.out.println(bigDecimal.multiply(new BigDecimal("1123123.21212312")));
        System.out.println(bigDecimal.divide(new BigDecimal("1123123.21212312"), RoundingMode.CEILING));



    }
}
