package org.cth.designPattern.bridge;

import org.cth.designPattern.decorator.Sourceable;

public class SourceSub1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
