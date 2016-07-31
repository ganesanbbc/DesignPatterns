package com.nsg.dp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nsg.dp.dao.AssetDataFetcher;
import com.nsg.dp.dao.DataFetcher;
import com.nsg.dp.dao.DataFetcherCallBack;
import com.nsg.dp.events.UpdateStatusEvent;
import com.nsg.dp.multirecycleview.MultiRecycleViewFragment;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements MainActivityPresenterListener {

    private MainActivityPresenter mainActivityPresenter;
    private Button button;
    private LinearLayout container;
    private FragmentTransaction ft;

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
        container = (LinearLayout) findViewById(R.id.container);
        loadFragment();

    }

    private void loadFragment() {
        ft = getSupportFragmentManager().beginTransaction();
//        SimpleRecycleViewFragment fragmentDemo = SimpleRecycleViewFragment.getInstance();
        MultiRecycleViewFragment fragmentDemo = MultiRecycleViewFragment.getInstance();
        ft.add(R.id.container, fragmentDemo,"sample");
        ft.commit();
    }

    @Override
    public void updateStatus() {
        ((TextView) findViewById(R.id.textView)).setText("Status Updated");

//        SimpleRecycleViewFragment fragmentDemo = (SimpleRecycleViewFragment) getSupportFragmentManager().findFragmentById(R.id.container);
//        fragmentDemo.reloadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);

        DataFetcher dataFetcher = new AssetDataFetcher(this,"config");
        dataFetcher.fetch(new DataFetcherCallBack(){

            @Override
            public void onSuccess(byte[] data) {
                String configData = new String(data);
                ((TextView) findViewById(R.id.textView)).setText(configData);

            }
        });
    }

    public void onEvent(UpdateStatusEvent event) {
        System.out.println("Called " + event.getMessage());

    }


}
