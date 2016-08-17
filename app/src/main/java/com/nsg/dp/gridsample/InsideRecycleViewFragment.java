package com.nsg.dp.gridsample;


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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by varshika on 05/08/16.
 */
public class InsideRecycleViewFragment extends Fragment {


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

        recycleView = (RecyclerView) view.findViewById(R.id.recycleview);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recycleView.setAdapter(new GridAdapter());

    }

    private class GridAdapter extends RecyclerView.Adapter<SampleViewHolder> {

        private Map<Integer, Boolean> expandMap = new HashMap();

        @Override
        public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SampleViewHolder(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.recycleview1, parent, false));
        }

        @Override
        public void onBindViewHolder(final SampleViewHolder holder, final int position) {
            holder.recycleView.setHasFixedSize(true);
            holder.recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
            holder.recycleView.setAdapter(new MyAdapter());

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean expanded = false;
                    if (expandMap.get(position) != null)
                        expanded = expandMap.get(position);

                    if (expanded) {
                        holder.recycleView.setVisibility(View.GONE);
                    } else {
                        holder.recycleView.setVisibility(View.VISIBLE);
                    }
                    expandMap.put(position, !expanded);
                }
            });

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

    private class SampleViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView recycleView;
        private final TextView textView1;

        public SampleViewHolder(View itemView) {
            super(itemView);
            recycleView = (RecyclerView) itemView.findViewById(R.id.recycleview);
            textView1 = (TextView) itemView.findViewById(R.id.textView4);
        }
    }
}
