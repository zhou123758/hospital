package com.wotrd.pojo.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.List;



public class JSONUtil {

    public static List jsonToList(String json, Class beanClass) {
        if (!StringUtils.isBlank(json)) {
            //这里的JSONObject引入的是 com.alibaba.fastjson.JSONObject;
            return JSONObject.parseArray(json, beanClass);
        } else {
            return null;
        }
    }

}
