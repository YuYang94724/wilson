package com.java.decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription());
        System.out.println(espresso.cost());
        System.out.println("-------------------------");
        espresso = new Milk(espresso);
        System.out.println(espresso.getDescription());
        System.out.println(espresso.cost());
    }

}
