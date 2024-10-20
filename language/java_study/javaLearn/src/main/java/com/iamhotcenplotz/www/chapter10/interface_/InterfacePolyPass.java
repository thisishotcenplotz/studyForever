package com.iamhotcenplotz.www.chapter10.interface_;
/**
 * 演示多态传递现象
 * */
public class InterfacePolyPass {
    public static void main(String[] args) {
        IG ig = new Teacher();

        // 多态传递
        IH ih = new Teacher();
    }
}


interface IH {}
interface IG extends IH{}

class Teacher implements IG { }