package org.cth.other;

import com.alibaba.fastjson.JSON;

public class JsonUtil {
    public static String toStr(Object obj){
        return JSON.toJSONString(obj);
    }
}
