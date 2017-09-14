package com.carlomatulessy.issuetracker.data;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Carlo on 11-9-2017.
 */

public class DateParser {

    public static String parseToDate(String data) {
        String result = "No data known";

        try{
            SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
            Date date = stringFormat.parse(data);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
            result = dateFormat.format(date);
        } catch (ParseException ex) {
            Log.e("DateParser", "Parse went wrong: "+ex);
        }

        return result;
    }
}
