package com.nsg.dp.java8;

import android.annotation.TargetApi;
import android.os.Build;

/**
 * Created by varshika on 17/07/16.
 */
public interface SampleDefault extends Cloneable{

    @TargetApi(Build.VERSION_CODES.N)
    default void defaultMethod() {
        System.out.println("I am in default Method");
    }

}
