package org.cth.designPattern.factory;

public class FactoryTest {
    public static void main(String[] args) {
        Provider pv = new SendMailFactory();
        Sender sd = pv.produce();
        sd.send();

    }
}
