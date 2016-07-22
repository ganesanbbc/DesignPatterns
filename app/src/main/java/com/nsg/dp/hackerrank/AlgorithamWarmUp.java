package com.nsg.dp.hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by varshika on 20/07/16.
 */
public class AlgorithamWarmUp {


    public static final String HH_MM_SS = "HH:mm:ss";

    public String get24_Hourstime(String dateInString, String givenPattern) {
        String format = null;

        try {
            Date date = new SimpleDateFormat(givenPattern).parse(dateInString);
            format = new SimpleDateFormat(HH_MM_SS).format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return format;
    }
}
