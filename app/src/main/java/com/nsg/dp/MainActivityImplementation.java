package com.nsg.dp;

/**
 * Created by varshika on 09/07/16.
 */
public class MainActivityImplementation implements MainActivityPresenter{
    private MainActivityPresenterListener listener;

    public MainActivityImplementation(MainActivityPresenterListener mainActivityPresenterListener) {

        this.listener = mainActivityPresenterListener;
    }

    @Override
    public void updateStatus() {
        listener.updateStatus();
    }
}
