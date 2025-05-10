package com.hotcenplotz.chapter05.exceptions_;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-05-10 08:41
 * @description: java异常回顾
 */


public class JavaExceptionReview {
    public static void main(String[] args) {

        try{
            int i = 0;
            int j = 1;
            int c = j / i;  // will throw error here.
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("java finally");
        }

    }
}
