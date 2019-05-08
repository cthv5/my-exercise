package org.cth.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {
    public static void main(String[] args) {
        String str = "var hq_str_RB1910=\"螺纹钢1910,103348,3756.00,3806.00,3753.00,3756.00,3796.00,3797.00,3797.00,3780.00,3758.00,39,666,2288386,1971222,沪,螺纹钢,2019-05-07,1,3833.000,3712.000,3833.000,3682.000,3843.000,3546.000,3843.000,3380.000,57.719\";";
        Pattern p = Pattern.compile("\"(.*?)\"");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println(m.group(0));
            String str1 = m.group(0);
            String str2 = str1.replaceAll("\"", "");
            System.out.println(str2);
            String[] arr = str2.split(",");
            System.out.println(arr.length);
            for (String item : arr){
                System.out.println(item);
            }
        }
    }
}
