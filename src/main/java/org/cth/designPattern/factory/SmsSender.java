package org.cth.designPattern.factory;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println(">>>send sms");
    }
}
