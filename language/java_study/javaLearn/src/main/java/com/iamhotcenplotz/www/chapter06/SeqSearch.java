package com.iamhotcenplotz.www.chapter06;

public class SeqSearch {
    public static void main(String[] args) {
        String[] names = {"a","b","c","d","e"};

        String target = "e";

        boolean flag = false;
        for (int i = 0; i < names.length; i++) {
            if (target.equals(names[i])){
                System.out.println(i);
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("not found "+target);
        }
    }
}
