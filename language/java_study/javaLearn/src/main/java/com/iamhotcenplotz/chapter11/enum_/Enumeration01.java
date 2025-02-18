package com.iamhotcenplotz.chapter11.enum_;

public class Enumeration01 {
    public static void main(String[] args) {
        Season1 spring = new Season1("Spring", "Warm");
        Season1 summer = new Season1("Summer", "Hot");
        Season1 autumn = new Season1("Autumn", "cool");
        Season1 winter = new Season1("Winter", "cold");

        // bad ...
    }
}

class Season1 {
    private String name;
    private String desc;

    public Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
