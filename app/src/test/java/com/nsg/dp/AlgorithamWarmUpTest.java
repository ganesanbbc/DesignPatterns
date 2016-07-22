package com.nsg.dp;

import com.nsg.dp.hackerrank.AlgorithmSamples;

import org.junit.Before;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by varshika on 20/07/16.
 */
public class AlgorithamWarmUpTest {


    AlgorithmSamples algorithamWarmUp = new AlgorithmSamples();

    @Before
    public void setUp() {
        algorithamWarmUp = new AlgorithmSamples();
    }


    @Test
    public void thatPrintTimeAs25HrsFormatWhenTimePass12HrsFormat() {
        String actualTime = "";
        String expected = "19:10:56";
        String dateInString = "7:10:56PM";
        String givenPattern = "hh:mm:ssa";

        actualTime = algorithamWarmUp.get24_Hourstime(dateInString, givenPattern);

        assertThat(actualTime, is(expected));
    }


    @Test
    public void thatDivisibleSumPairs() {
        int actualCount = 0;
        int[] array = {1, 3, 2, 6, 1, 2};
        int divisibleSum = 3;
        actualCount = algorithamWarmUp.getDivisibleSumPairs(array, divisibleSum);
        assertThat(actualCount, is(5));
    }

    @Test
    public void thatMinimumDistances() {
        int actualMinDist = 0;
        int[] array = {1, 3, 2, 6, 1, 2};
        actualMinDist = algorithamWarmUp.getMinimumDistances(array);
        assertThat(actualMinDist, is(3));


    }
}
