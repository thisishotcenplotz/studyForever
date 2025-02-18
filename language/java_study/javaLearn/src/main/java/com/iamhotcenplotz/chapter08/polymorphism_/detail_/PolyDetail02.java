package com.iamhotcenplotz.chapter08.polymorphism_.detail_;

public class PolyDetail02 {
    public void main(String[] args) {

        // 属性值看编译类型
        Base base = new Sub();
        System.out.println(base.count); // 10...

    }
}



class Base {
    int count = 10;
}

class Sub extends Base {
    int count = 20;
}
