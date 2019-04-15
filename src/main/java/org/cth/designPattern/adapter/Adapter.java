package org.cth.designPattern.adapter;

/**
 * 类的适配器模式
 */
public class Adapter extends Source implements Targetable{
    @Override
    public void method2() {
        System.out.println("this is the targetable override method");
    }
}
