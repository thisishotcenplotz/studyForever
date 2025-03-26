package com.iamhotcenplotz.chapter19.decorator.deco;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 3.14;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
