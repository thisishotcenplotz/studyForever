package com.iamhotcenplotz.www.chapter10.interface_;

public interface AInterface {
    public int n1 = 10;

    public void hi();

    default void ok(){
        System.out.println("ok...");
    }

    public static void cry(){
        System.out.println("cry...");
    }



}
