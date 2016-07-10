package com.nsg.dp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements MainActivityPresenterListener {

    private MainActivityPresenter mainActivityPresenter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter = new MainActivityImplementation(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mainActivityPresenter.updateStatus();
            }
        });
    }

    @Override
    public void updateStatus() {
        ((TextView) findViewById(R.id.textView)).setText("Status Updated");
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    public void onEvent(UpdateStatusEvent event) {
        System.out.println("Called " + event.getMessage());
    }

}
