package com.iamhotcenplotz.chapter19.decorator.deco;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Milk";
    }
}
