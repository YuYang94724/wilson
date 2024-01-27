package com.java.observer;

import javax.swing.*;
import java.awt.*;

public class Dog implements TickListener{
    private Point point;
    private ImageIcon dog = new ImageIcon("dog.png");

    public Dog(int x, int y){
        point = new Point(x, y);
    }

    public void dance(){
        int nexX = (int) (Math.random()*10-5);
        int nexY = (int) (Math.random()*10-5);
        point.x += nexX;
        point.y += nexY;
    }

    public void draw(Graphics graphics){
        dog.paintIcon(null, graphics, point.x, point.y);
    }
    @Override
    public void tick() {
        dance();
    }
}
