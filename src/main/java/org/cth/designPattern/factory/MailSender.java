package org.cth.designPattern.factory;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println(">>>send mail");
    }
}
