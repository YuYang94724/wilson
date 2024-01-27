package com.java.observer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;

public class ObserverMain extends JPanel implements TickListener {
    private ArrayList<RedPanda> redPandas = new ArrayList<>();
    private ArrayList<Dog> dogs = new ArrayList<>();

    private Timer timer;
    private int speed = 100;

    private TimerMission tm1 = new TimerMission();
    private TimerMission tm2 = new TimerMission();

    public ObserverMain(){
        timer = new Timer();
        timer.scheduleAtFixedRate(tm1, 0, speed);
        timer.scheduleAtFixedRate(tm2, 100, speed + 500);

        redPandas.add(new RedPanda(30, 30));
        redPandas.add(new RedPanda(90, 100));
        redPandas.add(new RedPanda(230, 230));
        for (RedPanda redPanda : redPandas) {
            tm1.register(redPanda);
        }
        tm1.register(this);

        dogs.add(new Dog(200, 100));
        dogs.add(new Dog(300, 50));
        dogs.add(new Dog(400, 400));
        for (Dog dog : dogs) {
            tm2.register(dog);
        }
        tm2.register(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (RedPanda redPanda : redPandas) {
            redPanda.draw(g);
        }
        for (Dog dog : dogs) {
            dog.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setContentPane(new ObserverMain());
        window.setVisible(true);
    }

    @Override
    public void tick() {
        repaint();
    }
}
