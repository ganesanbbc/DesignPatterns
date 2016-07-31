package com.nsg.dp.multirecycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nsg.dp.R;

/**
 * Created by varshika on 31/07/16.
 */
public class MultiRecycleViewFragment extends Fragment {

    private RecyclerView recycleView;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycleview_sample, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (TextView) view.findViewById(R.id.textView2);
        textView.setText("MultiRecycleViewFragment");
        recycleView = (RecyclerView) view.findViewById(R.id.recycleview);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MultiRecycleViewAdapter adapter = new MultiRecycleViewAdapter(getActivity());
        adapter.setPageAdapter(new CustomPageAdapter(getActivity()));
        recycleView.setAdapter(adapter);

    }

    public static MultiRecycleViewFragment getInstance() {
        return new MultiRecycleViewFragment();
    }


}
