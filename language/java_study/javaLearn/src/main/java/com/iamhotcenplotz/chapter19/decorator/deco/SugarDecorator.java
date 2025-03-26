package com.iamhotcenplotz.chapter19.decorator.deco;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost()+0.3;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}
