package com.java.decorator;

public class Whip extends CondimentDecorator{

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return this.beverage.cost() + 15;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Whip";
    }
}
