package com.iamhotcenplotz.chapter23.reflection;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Car {
    public String brand = "BMW";
    public int price = 10000;
    public String color = "red";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
