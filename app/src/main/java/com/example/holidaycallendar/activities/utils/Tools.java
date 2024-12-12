package com.example.holidaycallendar.activities.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Tools {

    public static String setDate(String strDate) {
        SimpleDateFormat formatDefault = new SimpleDateFormat("yyyy-MM-d");
        SimpleDateFormat formatTime = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        try {
            Date timesFormatCreated = formatDefault.parse(strDate);
            assert timesFormatCreated != null;
            strDate = formatTime.format(timesFormatCreated);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strDate;
    }

}