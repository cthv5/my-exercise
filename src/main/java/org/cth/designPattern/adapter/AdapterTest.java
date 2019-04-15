package org.cth.designPattern.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        Targetable tt = new Adapter();//Source的功能扩展到Targetable里
        tt.method1();
        tt.method2();
    }
}
