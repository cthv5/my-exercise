package org.cth.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStr {
    private static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = Pattern.compile("_(\\w)").matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.substring(0,1).toUpperCase() + sb.substring(1) + "Service";
    }

    public static void main(String[] args) {
        String target = "SEC_USER_AAS";
        System.out.println(lineToHump(target));
    }
}
