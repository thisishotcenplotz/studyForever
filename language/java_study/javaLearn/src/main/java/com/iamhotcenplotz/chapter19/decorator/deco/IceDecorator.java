package com.iamhotcenplotz.chapter19.decorator.deco;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class IceDecorator extends CoffeeDecorator{
    public IceDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.1;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Ice";
    }
}
