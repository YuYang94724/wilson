package com.java.decorator;

public class Decaf  extends Beverage{
    public Decaf(){
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 125;
    }
}
