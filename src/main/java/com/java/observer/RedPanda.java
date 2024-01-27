package com.java.observer;

import javax.swing.*;
import java.awt.*;

public class RedPanda implements TickListener{

    private Point point;
    private ImageIcon redPanda = new ImageIcon("red-panda.png");

    public RedPanda(int x, int y){
        point = new Point(x, y);
    }

    public void dance(){
        int nexX = (int) (Math.random()*10-5);
        int nexY = (int) (Math.random()*10-5);
        point.x += nexX;
        point.y += nexY;
    }

    public void draw(Graphics graphics){
        redPanda.paintIcon(null, graphics, point.x, point.y);
    }
    @Override
    public void tick() {
        dance();
    }
}
