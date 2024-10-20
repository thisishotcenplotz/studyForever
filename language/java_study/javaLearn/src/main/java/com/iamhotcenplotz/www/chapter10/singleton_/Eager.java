package com.iamhotcenplotz.www.chapter10.singleton_;

public class Eager {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        GirlFriend instance1 = GirlFriend.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}


class GirlFriend {
    private String name;

    private static GirlFriend girlFriend = new GirlFriend("大漂亮");

    // 1. 私有化构造器
    // 2. 在类的内部直接创建
    // 3. 提供一个static方法，返回gf对象。
    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return girlFriend;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}