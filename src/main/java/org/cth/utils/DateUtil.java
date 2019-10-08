package org.cth.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description: 日期格式处理
 * @author lujun
 * @date 2019年8月30日 下午1:36:28
 */
public class DateUtil {

    //输入的被转化的时间格式
    private static List<String> supportedFormats = Arrays.asList(
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSS",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd HH:mm:ss.SSS",
            "yyyy-MM-dd HH:mm:ss");

    //需要转化成的时间格式
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 字符串时间格式转换需要的字符串时间格式
     * @param sDate
     * @return  yyyy-MM-dd HH:mm:ss 时间格式
     */
    public static  String formatToDate(String sDate){
        Date date = parseSDateToDate(sDate);
        if(date != null){
            return formatter.format(date);
        }
        return null;
    }
    /**
     * 根据时间格式列表，将时间字符串转化成时间
     * @param sDate 时间字符串
     * @return Date
     */
    private static  Date parseSDateToDate(String sDate) {
        if (sDate.isEmpty()) {
            return null;
        }
        for (int i=0;i<supportedFormats.size();i++) {
            try {
                DateFormat formatter = new SimpleDateFormat(supportedFormats.get(i));
                Date date = formatter.parse(sDate);
                return date;
            } catch (ParseException ex) {
                continue;
            }
        }
        return null;
    }



    /**
     * 判断时间格式 格式必须为“YYYY-MM-dd”
     * 2004-2-30 是无效的
     * 2003-2-29 是无效的
     * @param sDate
     * @return
     */
    private static boolean isLegalDate(String sDate) {
        int legalLen = 10;
        if ((sDate == null) || (sDate.length() != legalLen)) {
            return false;
        }
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(sDate);
            return sDate.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }

    }
}

