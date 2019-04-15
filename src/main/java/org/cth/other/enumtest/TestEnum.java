package org.cth.other.enumtest;

public enum TestEnum {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(7, "星期日");
    private int index;
    private String name;

    TestEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }


    public String getName() {
        return name;
    }
}
