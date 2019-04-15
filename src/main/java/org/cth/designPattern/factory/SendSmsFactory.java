package org.cth.designPattern.factory;

public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }//工厂用于创建
}
