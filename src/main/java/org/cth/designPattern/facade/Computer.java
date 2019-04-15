package org.cth.designPattern.facade;

public class Computer {
    private Cpu cpu;
    private Disk disk;
    private Memory my;

    public Computer() {
        this.cpu = new Cpu();
        this.disk = new Disk();
        this.my = new Memory();
    }

    public void startup() {
        System.out.println("---start the computer");
        cpu.startup();
        disk.startup();
        my.startup();
        System.out.println("---start computer finished");
    }

    public void shutdown() {
        System.out.println("---begin to close the computer");
        cpu.shutdown();
        disk.shutdown();
        my.shutdown();
        System.out.println("---computer closed!");
    }
}
