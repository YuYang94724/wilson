package com.java.decorator;

public class Soy extends CondimentDecorator{

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return this.beverage.cost() + 25;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Soy";
    }
}
