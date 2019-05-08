package org.cth.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        Collections.sort(list, (x, y) -> x-y);
        for (Integer i: list) {
            System.out.println(i);
        }
    }
}
