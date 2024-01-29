package com.java.factory;

import java.util.Scanner;


abstract class Cake {
    abstract void makeCake();
}

class BlueBerry extends Cake {
    @Override
    void makeCake() {
        System.out.println("Making BlueBerry cake");
    }
}

class BlackForest extends Cake {
    @Override
    void makeCake() {
        System.out.println("Making BlackForest cake");
    }
}

class Cheese extends Cake {
    @Override
    void makeCake() {
        System.out.println("Making cheese cake");
    }
}

public class FactoryMain {

    public static void main(String[] args) {
        Cake cake = null;
        System.out.println(" chose your cake: ");
        Scanner scanner = new Scanner(System.in);
        String cakeType = scanner.nextLine();
        scanner.close();

        switch (cakeType) {
            case "BlueBerry" -> cake = new BlueBerry();
            case "BlackForest" -> cake = new BlackForest();
            case "Cheese" -> cake = new Cheese();
        }

        if (cake != null) {
            cake.makeCake();
        }
    }
}
