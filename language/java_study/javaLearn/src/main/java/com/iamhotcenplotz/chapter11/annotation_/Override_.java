package com.iamhotcenplotz.chapter11.annotation_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Override_ {
}


class Father {
    public String sayHi() {
        return "Hi";
    }
}

class Son extends Father {

    // @Override ，编译器会去检查是否真的重写了这个方法，如果写了编译通过，没写则报错；做了语法校验。
    @Override
    public String sayHi() {
        return "Hi";
    }
}