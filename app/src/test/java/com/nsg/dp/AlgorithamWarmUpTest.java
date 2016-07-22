package com.nsg.dp;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by varshika on 20/07/16.
 */
public class AlgorithamWarmUpTest {


    @Test
    public void test(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateInString = "7:10:56PM";
//        SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
