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

    /**
     * You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height.
     * You can change the height of a stack by removing and discarding its topmost cylinder any number of times.
     * <p/>
     * Find the maximum possible height of the stacks such that all of the stacks are exactly the same height.
     * This means you must remove zero or more cylinders from the top of zero or more of the three stacks until
     * they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.
     * <p/>
     * Note: An empty stack is still a stack.
     *
     * @param stacks
     * @return
     */

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
        for (Integer stackWeight : stackWeights) {
            if (someWeight != stackWeight) {
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


    public int getEqualStackWeight(List<List<Integer>> stacks) {

        int minHeight = findMinHeight(stacks);
        while (!isAllStackSameWeight(stacks)) {
            List<Integer> indexList = findMAxWeightStackIndex(stacks, minHeight);
            for (Integer integer : indexList) {
                resizeStack(stacks.get(integer), minHeight);
            }
            minHeight = findMinHeight(stacks);
        }
        return findMinHeight(stacks);
    }

    private void resizeStack(List<Integer> integers, int minHeight) {
        List<Integer> tempStack = new ArrayList<>();

        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
            if (sum <= minHeight) {
                tempStack.add(integer);
            } else {
                break;
            }
        }
        integers.clear();
        integers.addAll(tempStack);
    }

    private List<Integer> findMAxWeightStackIndex(List<List<Integer>> stacks, int minHeight) {
        List<Integer> index = new ArrayList<>();
        int i = 0;
        for (List<Integer> stack : stacks) {
            int sum = getSum(stack);
            if (sum != minHeight) {
                index.add(i);
            }
            i++;
        }
        return index;
    }



}
