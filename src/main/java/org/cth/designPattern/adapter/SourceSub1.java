package org.cth.designPattern.adapter;

public class SourceSub1 extends Adapter2{
    @Override
    public void method1() {//只要sourceable的method1
        System.out.println("the sourceable interface's method1");
    }
}
