package org.cth.other;

import java.util.ArrayList;
import java.util.List;

public class TestReturn {
    private static int returnNum() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        for (Integer id : a) {
            System.out.println(id);
            if (id.equals(4)) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int b = returnNum();
        System.out.println(b);
        Integer a = 1;
        System.out.println(a.equals(1));
    }
}
