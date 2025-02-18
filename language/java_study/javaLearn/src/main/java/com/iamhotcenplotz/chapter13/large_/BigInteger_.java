package com.iamhotcenplotz.chapter13.large_;

import java.math.BigInteger;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class BigInteger_ {
    public static void main(String[] args) {
        // when one needs to process a large Integer which is
        // greater than the maximum number of long, then BigInteger
        // will be a good choice.

        BigInteger bigInteger = new BigInteger("123333333333333333333333333");

        System.out.println(bigInteger.add(new BigInteger("123")));
        System.out.println(bigInteger.subtract(new BigInteger("123")));
        System.out.println(bigInteger.multiply(new BigInteger("123")));
        System.out.println(bigInteger.divide(new BigInteger("123")));


        System.out.println(bigInteger);
    }
}
