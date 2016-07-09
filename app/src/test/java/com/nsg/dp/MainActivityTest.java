package com.nsg.dp;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThat;

/**
 * Created by varshika on 09/07/16.
 */
public class MainActivityTest {


    private boolean updatedStatusCalled;

    @Test
    public void thatUpdateStatusWhenButtonInvoked(){

        updatedStatusCalled = false;

        MainActivityPresenter mainActivityPresenter = new MainActivityImplementation(new MainActivityPresenterListener(){

            @Override
            public void updateStatus() {
                updatedStatusCalled = true;
            }
        });
        mainActivityPresenter.updateStatus();
        assertTrue(updatedStatusCalled);
    }
}
