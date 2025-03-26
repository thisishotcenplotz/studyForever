package com.iamhotcenplotz.chapter19.decorator.deco;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class CoffeeMain {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        coffee = new IceDecorator(coffee);

        System.out.println(coffee.getCost());
        System.out.println(coffee.getDescription());
    }
}
