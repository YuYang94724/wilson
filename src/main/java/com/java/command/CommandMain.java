package com.java.command;


import java.util.Stack;

interface Command {
    void execute();
    void undo();
}
class LightsOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println( "Lights are on" );
    }

    @Override
    public void undo() {
        System.out.println("Lights are off");
    }
}

class LightsOffCommand implements Command {

    LightsOnCommand lightsOnCommand = new LightsOnCommand();

    @Override
    public void execute() {
        lightsOnCommand.undo();
    }

    @Override
    public void undo() {
        lightsOnCommand.execute();
    }
}
class RemoteControl {
    Stack<Command> stack = new Stack<>();
    LightsOnCommand lightsOnCommand = new LightsOnCommand();
    LightsOffCommand lightsOffCommand = new LightsOffCommand();

    // 8 buttons
    // 1 開燈
    public void button1() {
        lightsOnCommand.execute();
        stack.add(lightsOnCommand);
    }
    // 2 關燈
    public void button2() {
        lightsOffCommand.execute();
        stack.add(lightsOffCommand);
    }
    // ...

    public void undo() {
        Command lastCommand = stack.pop();
        lastCommand.undo();
    }

}

public class CommandMain {
    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.button1();
        remoteControl.button1();
        remoteControl.button2();
        remoteControl.undo();
        remoteControl.undo();
        remoteControl.undo();
    }
}
