package org.cth.designPattern.adapter;

public class Adapter2Test {
    public static void main(String[] args) {
        Sourceable sc1 = new SourceSub1();
        sc1.method1();
        sc1.method2();
        System.out.println("-------------");
        Sourceable sc2 = new SourceSub2();
        sc2.method1();
        sc2.method2();
    }
}
