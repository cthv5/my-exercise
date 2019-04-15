package org.cth.designPattern.decorator;

public class Decorator implements Sourceable {
    private Sourceable sa;

    public Decorator(Sourceable sa) {
        this.sa = sa;
    }

    @Override
    public void method() {
        System.out.println("before decorator");
        sa.method();
        System.out.println("after decorator");
    }
}
