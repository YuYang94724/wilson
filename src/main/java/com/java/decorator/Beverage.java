package com.java.decorator;

public abstract class Beverage {
    String description = "Unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public void style(){
        System.out.println("This is a Taiwanese style coffee");
    }
}
