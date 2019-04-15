package org.cth.other.enumtest;

public enum TestEnum2 {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);
    private int num;

    TestEnum2(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
