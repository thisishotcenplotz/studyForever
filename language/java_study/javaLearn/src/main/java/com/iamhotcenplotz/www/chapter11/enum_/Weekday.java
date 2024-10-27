package com.iamhotcenplotz.www.chapter11.enum_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public enum Weekday implements SayHi{
    MONDAY("Monday","星期一"),
    TUESDAY("Tuesday","星期二"),
    WEDNESDAY("Wednesday","星期三"),
    THURSDAY("Thursday","星期四"),
    FRIDAY("Friday","星期五"),
    SATURDAY("Saturday","星期六"),
    SUNDAY("Sunday","星期日");

    private final String name;
    private final String value;

    Weekday(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String sayHi() {
        return "Hi ~~~ " + this.name;
    }
}
