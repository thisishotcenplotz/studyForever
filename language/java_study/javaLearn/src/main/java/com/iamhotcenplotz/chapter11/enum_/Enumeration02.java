package com.iamhotcenplotz.chapter11.enum_;

public class Enumeration02 {
    public static void main(String[] args) {
        Season2 spring = Season2.spring;
        Season2 summer = Season2.summer;
        Season2 autumn = Season2.autumn;
        Season2 winter = Season2.winter;

        // good ...
    }
}

// 自定义枚举实现
class Season2 {
    private String name;
    private String desc;

    public final static Season2 spring = new Season2("Spring", "Warm");
    public final static Season2 summer = new Season2("Summer", "Hot");
    public final static Season2 autumn = new Season2("Autumn", "cool");
    public final static Season2 winter = new Season2("Winter", "cold");

    // 1. 构造器私有化，防止被new出来
    // 2. 去除set方法，防止修改
    // 3. 在该类内部创建固定的对象
    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

}
