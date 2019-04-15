package org.cth.designPattern.bridge;

import org.cth.designPattern.decorator.Sourceable;

public class BridgeTest {
    public static void main(String[] args) {
        Bridge bg = new MyBridge();//桥接模式
        Sourceable su1 = new SourceSub1();
        bg.setSa(su1);
        bg.method1();

        Sourceable su2 = new SourceSub2();
        bg.setSa(su2);
        bg.method1();
    }
}
