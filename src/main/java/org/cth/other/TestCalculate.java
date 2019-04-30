package org.cth.other;

public class TestCalculate {

    private static int plus(int a, int b) {
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }

    private static String getType(Object test) {
        return test.getClass().getName().toString();
    }

    public static void main(String[] args) {
       int result = plus(10, 10);
       System.out.println(result);
        int result1 = plus(11, 7);
        System.out.println(result1);
        System.out.println(3 * 0.1f);
        System.out.println(3 * 0.1);
        System.out.println(3 * 0.5);
        System.out.println(0.3);
        System.out.println(getType(0.3));
    }
}
