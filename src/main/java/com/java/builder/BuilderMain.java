package com.java.builder;

class Pizza{
    private String sauce;
    private String topping;
    private String dough;
    //當屬性太多時，使用builder模式可以避免重複建構函式
    public Pizza(String sauce, String topping, String dough) {
        this.dough = dough;
        this.sauce = sauce;
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                ", dough='" + dough + '\'' +
                '}';
    }
}

class PizzaBuilder{
    private String sauce = "cross";
    private String topping = "mushroom";
    private String dough = "thin";

    public Pizza returnPizza(){
        return new Pizza(sauce, topping, dough);
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }
}

public class BuilderMain {
    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        pizzaBuilder.setDough("berry");
        pizzaBuilder.setTopping("pepperoni");
        Pizza pizza = pizzaBuilder.returnPizza();
        System.out.println(pizza);
    }
}
