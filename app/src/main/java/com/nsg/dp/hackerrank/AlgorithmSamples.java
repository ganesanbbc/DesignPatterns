package com.nsg.dp.hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                if (array[i] == array[i1]) {
                    if (minDistances == -1 || minDistances > dist) {
                        minDistances = dist;
                    }
                    break;
                }
            }
        }
        return minDistances;
    }

    /**
     * A Discrete Mathematics professor has a class of  students. Frustrated with their lack of discipline,
     * he decides to cancel class if fewer than  students are present when class starts.
     * Given the arrival time of each student, determine if the class is canceled.
     *
     * @param a
     * @param thresholdValue
     */

    public String hasClassCancelled(int[] a, int thresholdValue) {

        String result = "YES";
        int inTimeCount = 0;
        for (int i : a) {
            if (i >= 0) {
                inTimeCount++;
                if (inTimeCount >= thresholdValue) {
                    result = "NO";
                    break;
                }
            }
        }

        return result;
    }

    public int findMinHeight(List<List<Integer>> stacks) {
        int minHeight = Integer.MAX_VALUE;
        for (List<Integer> stack : stacks) {
            int sum = getSum(stack);
            minHeight = sum < minHeight ? sum : minHeight;
        }
        return minHeight;
    }

    public boolean isAllStackSameWeight(List<List<Integer>> stacks) {

        boolean hasSameWeight = true;
        List<Integer> stackWeights = new ArrayList<>();
        for (List<Integer> stack : stacks) {
            int sum = getSum(stack);
            stackWeights.add(sum);
        }

        int someWeight = stackWeights.get(0);
        for (int i = 1; i < stackWeights.size(); i++) {
            if (someWeight != stackWeights.get(i)) {
                hasSameWeight = false;
                break;
            }
        }
        return hasSameWeight;
    }

    private int getSum(List<Integer> stack) {
        int sum = 0;
        for (Integer integer : stack) {
            sum += integer;
        }
        return sum;
    }
}
