package com.nsg.dp.hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by varshika on 20/07/16.
 */
public class AlgorithmSamples {


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

    public int getDivisibleSumPairs(int[] array, int divisibleSum) {

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int i1 = i + 1; i1 < array.length; i1++) {
                count += (array[i] + array[i1]) % divisibleSum == 0 ? 1 : 0;
            }
        }
        return count;
    }

    public int getMinimumDistances(int[] array) {
        int minDistances = -1;
        for (int i = 0; i < array.length; i++) {
            int dist = 0;
            for (int i1 = i + 1; i1 < array.length; i1++) {
                dist++;
                if(array[i] == array[i1]){
                    if(minDistances==-1 || minDistances>dist) {
                        minDistances = dist;
                    }
                    break;
                }
            }
        }
        return minDistances;
    }
}
