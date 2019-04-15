package org.cth.designPattern.bridge;

import org.cth.designPattern.decorator.Sourceable;

public abstract class Bridge {//抽象类
    private Sourceable sa;

    public abstract void method1();

    public Sourceable getSa() {
        return sa;
    }

    public void setSa(Sourceable sa) {
        this.sa = sa;
    }
}
