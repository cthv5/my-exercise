package org.cth.designPattern.bridge;

public class MyBridge extends Bridge {
    @Override
    public void method1() {
        getSa().method();
    }
}
