package org.cth.other.enumtest;

public class MainTest {
    public static void main(String[] args) {
        for (TestEnum en : TestEnum.values()){
            System.out.println(en.getIndex()+":"+en.getName());
        }
    }
}
