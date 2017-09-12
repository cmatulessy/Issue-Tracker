package com.carlomatulessy.issuetracker.data;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Carlo on 11-9-2017.
 */

public class DateParser {

    public static String parseToDate(String data) {
        String result = "No data known";

        try{
            SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = stringFormat.parse(data);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            result = dateFormat.format(date);
        } catch (ParseException ex) {
            Log.e("DateParser", "Parse went wrong: "+ex);
        }

        return result;
    }
}
