package com.iamhotcenplotz.chapter07;

public class Tower {
    public static void main(String[] args) {
        T t = new T();
        t.move(10,'a','b','c');
    }
}


class T {
    // a b c 表示三座塔
    public void move(int num,char a, char b,char c){
        if (num == 1){
            System.out.println(a + " -> " + c);
        }else {
            move(num -1,a,c,b);
            System.out.println(a + " -> " +c);
            move(num -1,b,a,c);
        }
    }
}