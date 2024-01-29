package com.java.facade;

class CPU{
    public void movePoint(){}
    public void jump(){}
    public void freeze(){}

}

class Memory{
    public void load(){}
}

class HardDrive{
    public byte[] read(long position){
        return null;
    }
}
//Facade
class Computer{
    CPU cpu = new CPU();
    Memory memory = new Memory();
    HardDrive hardDrive = new HardDrive();

    public void start(){
        cpu.jump();
        cpu.movePoint();
        hardDrive.read(100);
        memory.load();
    }
}
public class FacadeMain {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
    }
}
