package org.cth.designPattern.adapter;

public class SourceSub2 extends Adapter2 {
    @Override
    public void method2() {//只要sourceable的method2
        System.out.println("the sourceable interface's method2");
    }
}
