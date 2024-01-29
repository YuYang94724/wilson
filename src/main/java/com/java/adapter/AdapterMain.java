package com.java.adapter;


interface Duck{
    void quack();
    void fly();
}

class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quark....");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying!");
        }
}


class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a little bit");
    }
}
interface Turkey{
    void gobble();
    void fly();
}
public class AdapterMain {
    public static void main(String[] args) {
        WildTurkey wildTurkey = new WildTurkey();
        Duck fakeDuck = new TurkeyAdapter(wildTurkey);
        fakeDuck.fly();
        fakeDuck.quack();
    }
}
