package org.cth.designPattern.facade;

public class User {
    public static void main(String[] args) {
        Computer cpt = new Computer();//外观模式
        cpt.startup();
        cpt.shutdown();
    }
}
