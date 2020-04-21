package com.wotrd.pojo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {

    public static Date stringToDate(String time){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
