package com.nsg.dp;

import org.testng.annotations.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by varshika on 26/07/16.
 */
public class HRJavaSampleTest {

    @Test
    public void thatJavaStringsIntroduction() {

        String a = "hello";
        String b = "java";

        int totalLength = a.length() + b.length();
        System.out.println(totalLength);

        System.out.println((int) a.charAt(0));
        System.out.println((int) b.charAt(0));
        System.out.println((int) 'a');

        System.out.println(a.substring(0,1).toUpperCase()+a.substring(1,a.length()));

        boolean expectedResult = (int) a.charAt(0) < (int) b.charAt(0);
        assertTrue(expectedResult);

    }
}
