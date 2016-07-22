package com.nsg.dp;

import com.nsg.dp.hackerrank.AlgorithamWarmUp;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by varshika on 20/07/16.
 */
public class AlgorithamWarmUpTest {


    @Test
    public void thatPrintTimeAs25HrsFormatWhenTimePass12HrsFormat() {
        String actualTime = "";
        String expected = "19:10:56";
        String dateInString = "7:10:56PM";
        String givenPattern = "hh:mm:ssa";

        AlgorithamWarmUp algorithamWarmUp = new AlgorithamWarmUp();
        actualTime = algorithamWarmUp.get24_Hourstime(dateInString, givenPattern);

        assertThat(actualTime, is(expected));
    }
}
