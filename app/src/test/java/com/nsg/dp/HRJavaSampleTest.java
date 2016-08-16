package com.nsg.dp;

import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static junit.framework.Assert.assertTrue;


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

        System.out.println(a.substring(0, 1).toUpperCase() + a.substring(1, a.length()));

        boolean expectedResult = (int) a.charAt(0) < (int) b.charAt(0);
        assertTrue(expectedResult);

    }


    @Test
    public void thatStringBuffer() {


        linkedMapSample();



    }

    private void linkedMapSample() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(10, "100");
        map.put(12, "100");
        map.put(2, "100");
        map.put(1, "100");

        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.entrySet());


//        for (Integer integer : map.keySet()) {
//            System.out.println(integer);
//        }
//        for (String values : map.values()) {
//            System.out.println(values);
//        }
    }

    private void treeMapSample() {
        TreeMap<Integer, String> treeMap = new TreeMap();
        treeMap.put(10, "100");
        treeMap.put(12, "100");
        treeMap.put(2, "100");
        treeMap.put(1, "100");

        System.out.println(treeMap);
        System.out.println(treeMap.entrySet());

        for (Integer integer : treeMap.keySet()) {
            System.out.println(integer);
        }
        for (String values : treeMap.values()) {
            System.out.println(values);
        }
    }

    private void StringBufferSample() {
        StringBuffer stringBuffer = new StringBuffer("Hai,");
        stringBuffer.append("Ganesan");
        System.out.println(stringBuffer);
    }


}
