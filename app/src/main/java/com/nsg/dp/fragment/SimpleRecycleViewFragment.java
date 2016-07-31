package com.nsg.dp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nsg.dp.R;
import com.nsg.dp.fragment.SimpleRecycleViewSampleAdapter.RecycleViewClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varshika on 31/07/16.
 */
public class SimpleRecycleViewFragment extends Fragment {

    private RecyclerView recycleView;
    private SimpleRecycleViewSampleAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycleview_sample, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleView = (RecyclerView) view.findViewById(R.id.recycleview);
        initRecycleView();
    }

    private void initRecycleView() {
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new SimpleRecycleViewSampleAdapter();
        adapter.setDataSet(getDataSet());
        recycleView.setAdapter(adapter);
        adapter.setClickListener(new RecycleViewClickListener() {
            @Override
            public void onItemClick(int position) {
                if(position%2==0) {
                    adapter.addItem(position);
                }else{
                    adapter.removeItem(position);
                }
            }
        });

    }

    private List<String> getDataSet() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            data.add("Position::" + i);
        }
        return data;
    }


    public static SimpleRecycleViewFragment getInstance() {
        return new SimpleRecycleViewFragment();
    }

    public void reloadData() {
        adapter.setDataSet(getDataSet());
        adapter.notifyDataSetChanged();
    }
}
