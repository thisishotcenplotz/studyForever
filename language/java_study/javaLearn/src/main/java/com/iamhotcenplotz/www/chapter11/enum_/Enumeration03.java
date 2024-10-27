package com.iamhotcenplotz.www.chapter11.enum_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Enumeration03 {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        Season summer = Season.SUMMER;
        Season autumn = Season.AUTUMN;
        Season winter = Season.WINTER;

        System.out.println(spring);

        System.out.println(spring.name());

        System.out.println(spring.ordinal());

        Season[] values = Season.values();
        for (Season season : values) {
            System.out.println(season.name());
        }

        Season spring1 = Season.valueOf("SPRING");
        System.out.println(spring1.name());

        // return self.ordinal - other.ordinal --> 两个编号相减
        System.out.println(Season.SPRING.compareTo(Season.SPRING));
    }
}

enum Season{
    SPRING("Spring","warm"),
    SUMMER("Summer","hot"),
    AUTUMN("Autumn","warm"),
    WINTER("Winter","hot");


    private final String name;
    private final String desc;


    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "name = " + name + " desc = " + desc;
    }
}
