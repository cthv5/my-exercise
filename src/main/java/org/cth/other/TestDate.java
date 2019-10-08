package org.cth.other;

import org.cth.utils.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        System.out.println(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(sdf.parse(sdf.format(new Date())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sDate = "2019-01-07T00:00:00";
        String date = DateUtil.formatToDate(sDate);
        System.out.println("TO_DATE('"+date+"','yyyy-mm-DD hh24:mi:ss')");
    }
}
