package com.java.observer;

import java.util.ArrayList;
import java.util.TimerTask;

public class TimerMission extends TimerTask {
    private ArrayList<TickListener> tickListeners = new ArrayList<>();

    public void register(TickListener t){
        tickListeners.add(t);
    }

    public void unregister(TickListener t){
        tickListeners.remove(t);
    }
    @Override
    public void run() {
        for (TickListener t : tickListeners){
            t.tick();
        }
    }
}
