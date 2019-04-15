package org.cth.other;

public class TestSourceCode {
    public static void main(String[] args) {
        Boolean a = new Boolean("false");
        System.out.println(a.booleanValue());
        Boolean b = new Boolean("false");
        System.out.println(a.equals(b));
        System.out.println(a == b);
        Boolean c = Boolean.valueOf("false");
        Boolean d = Boolean.valueOf("false");
        System.out.println(a.equals(c));
        System.out.println(a == c);
        System.out.println(c.equals(d));
        System.out.println(c == d);
    }
}
