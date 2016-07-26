package com.nsg.dp;

import com.nsg.dp.hackerrank.AlgorithmSamples;

import org.junit.Before;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
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

    @Test
    public void thatAngryProfessorHasCancelledClassWhenStudentDoesNotMeetExpectation() {
        String expectedDicision = "YES";
        int[] a = {-1, -3, 4, 2};
        int thresholdValue = 3;
        String actualDicision = algorithamWarmUp.hasClassCancelled(a, thresholdValue);
        assertThat(actualDicision, is(expectedDicision));
    }

    @Test
    public void thatAngryProfessorHasNotCancelledClassWhenStudentDoesMeetExpectation() {
        String expectedDicision = "NO";
        int[] a = {0, -1, 2, 1};
        int thresholdValue = 2;
        String actualDicision = algorithamWarmUp.hasClassCancelled(a, thresholdValue);
        assertThat(actualDicision, is(expectedDicision));
    }

    @Test
    public void thatFindMinHeight() {

        int actualMinHeight;
        int expectedMinHeight = 28;

        List<List<Integer>> stacks = new ArrayList<>();
        stacks.add(new ArrayList<Integer>() {{
            add(25);
            add(10);
        }});

        stacks.add(new ArrayList<Integer>() {{
            add(15);
            add(13);
        }});

        actualMinHeight = algorithamWarmUp.findMinHeight(stacks);

        assertThat(actualMinHeight, is(expectedMinHeight));
    }


    @Test
    public void thatAllStackWeightAreNotEquaWeight() {
        boolean hasSameWeight = false;
        List<List<Integer>> stacks = new ArrayList<>();
        stacks.add(new ArrayList<Integer>() {{
            add(25);
            add(10);
        }});

        stacks.add(new ArrayList<Integer>() {{
            add(15);
            add(13);
        }});

        hasSameWeight = algorithamWarmUp.isAllStackSameWeight(stacks);
        assertFalse(hasSameWeight);
    }

    @Test
    public void thatAllStackWeightAreEquaWeight() {
        boolean hasSameWeight = false;
        List<List<Integer>> stacks = new ArrayList<>();
        stacks.add(new ArrayList<Integer>() {{
            add(10);
            add(10);
        }});
        stacks.add(new ArrayList<Integer>() {{
            add(15);
            add(5);
        }});
        hasSameWeight = algorithamWarmUp.isAllStackSameWeight(stacks);
        assertTrue(hasSameWeight);
    }

    @Test
    public void thatGetStackEquaWeight() {


        int actualStackHeight;
        int expectedHeight = 10;

        List<List<Integer>> stacks = new ArrayList<>();
        stacks.add(new ArrayList<Integer>() {{
            add(10);
            add(10);
        }});

        stacks.add(new ArrayList<Integer>() {{
            add(10);
            add(20);
        }});

        actualStackHeight = algorithamWarmUp.getEqualStackWeight(stacks);

        assertThat(actualStackHeight, is(expectedHeight));
    }

}
