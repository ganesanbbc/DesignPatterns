package com.nsg.dp.java8;

/**
 * Created by varshika on 17/07/16.
 */
public class JavaNewFeatures implements SampleDefault{


    public static void usingLambda() {
        FunctionalInterface sine = (x, y) -> {
            double x1 = Math.sin(x);
            x1 += 10;
            return x1;
        };
        System.out.println(sine.getValue(10, 0));

    }


}
