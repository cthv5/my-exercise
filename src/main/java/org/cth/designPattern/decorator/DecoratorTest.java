package org.cth.designPattern.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Sourceable sa = new Source();
        Sourceable obj = new Decorator(sa);//装饰模式
        obj.method();
    }
}
