package com.iamhotcenplotz.chapter15.custom;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class CustomInterfaceWithGenerics_ {
    public static void main(String[] args) {

    }
}

interface Hello<U,R> {
    R get(U u);

    void hi(R r);

    void run(R r1, R r2,U u1,U u2);

    default R method(U u){
        return null;
    }
}
