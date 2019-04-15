package org.cth.designPattern.factory;

public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }//工厂用于创建
}
