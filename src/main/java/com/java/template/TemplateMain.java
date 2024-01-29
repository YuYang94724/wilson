package com.java.template;

abstract class Template {
    abstract void doing();
    public void print(){
        System.out.println("everyone can use print");
    }
}

class ConcreteTemplate extends Template{

    @Override
    void doing() {
        System.out.println("ConcreteTemplate!");
    }
}

class AnotherTemplate extends Template{

    @Override
    void doing() {
        System.out.println("AnotherTemplate!");
    }
}

public class TemplateMain {
    public static void main(String[] args) {
        Template concreteTemplate = new ConcreteTemplate();
        concreteTemplate.doing();
        Template anotherTemplate = new AnotherTemplate();
        anotherTemplate.doing();
    }
}
