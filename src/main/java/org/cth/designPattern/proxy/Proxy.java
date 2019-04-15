package org.cth.designPattern.proxy;

import org.cth.designPattern.decorator.Source;
import org.cth.designPattern.decorator.Sourceable;

public class Proxy implements Sourceable {
    private Source sc;
    public Proxy(){
        this.sc = new Source();
    }
    @Override
    public void method() {
        System.out.println("before decorator");
        sc.method();
        System.out.println("after decorator");
    }
}
