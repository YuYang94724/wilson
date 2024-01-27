package com.java.decorator;

public class Mocha extends CondimentDecorator{

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return this.beverage.cost() + 50;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }

    @Override
    public void style(){
        super.style();
        System.out.println("Also, it has italian style...");
    }
}
