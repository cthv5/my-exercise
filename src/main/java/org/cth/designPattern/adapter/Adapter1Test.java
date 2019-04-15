package org.cth.designPattern.adapter;

public class Adapter1Test {
    public static void main(String[] args) {
        Source sc = new Source();
        Targetable tt = new Adapter1(sc);
        ((Adapter1) tt).a();
        tt.method1();
        tt.method2();
    }
}
