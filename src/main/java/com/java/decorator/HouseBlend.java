package com.java.decorator;

public class HouseBlend extends Beverage{
    public HouseBlend(){
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 300;
    }
}
