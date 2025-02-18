package com.iamhotcenplotz.chapter04;

public class InverseOperator {
    public static void main(String[] args) {
        System.out.println(!(60 > 20));

        // case
        //   when a == true and b == true then true
        //   when a == false and b == false then true
        //   else false
        // end;
        System.out.println((60 > 20) ^ (30 > 40));
        System.out.println((60 > 20) ^ (30 < 40));
        System.out.println((60 < 20) ^ (30 < 40));
    }
}
