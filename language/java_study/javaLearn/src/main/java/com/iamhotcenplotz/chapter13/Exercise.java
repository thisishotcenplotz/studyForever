package com.iamhotcenplotz.chapter13;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise {
    public static void main(String[] args) {
        System.out.println(Exercise01.reverse("000 123 000", 3, 7));
    }
}

class Exercise01 {
    public static String reverse(String str, int start, int end) {
        if(start >= end){
            throw new RuntimeException("...");
        }

        if (end > str.length()){
            throw new RuntimeException("+++");
        }


        char[] charArray = str.toCharArray();

        char temp;

        for (int i = start, j = end; i < j; i++, j--) {
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

        return String.valueOf(charArray);
    }
}
