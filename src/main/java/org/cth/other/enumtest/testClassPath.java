package org.cth.other.enumtest;

import java.util.Arrays;

public class testClassPath {
    public static void main(String[] args) {
        String name = "stk_outstockapply1";
        String result = "";
        try {
            result = MesClassPathEnum.getClassFullName(name);
        } catch (Exception e) {
            result = String.format("找不到[%s]对应的类路径", name);
        }
        System.out.println(result);
        Arrays.stream(MesClassPathEnum.dataArr).forEach(System.out::println);
    }
}
