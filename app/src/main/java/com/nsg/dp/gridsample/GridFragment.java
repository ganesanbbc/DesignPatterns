package com.nsg.dp.gridsample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nsg.dp.R;

/**
 * Created by varshika on 05/08/16.
 */
public class GridFragment extends Fragment {


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
        textView.setText("GridRecycleViewFragment");
        recycleView = (RecyclerView) view.findViewById(R.id.recycleview);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
//        recycleView.addItemDecoration(itemDecoration);

        recycleView.setAdapter(new GridAdapter());

    }

    private class GridAdapter extends RecyclerView.Adapter<SampleViewHolder> {
        @Override
        public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SampleViewHolder(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.grid_item, parent, false));
        }

        @Override
        public void onBindViewHolder(SampleViewHolder holder, int position) {

            holder.textView1.setText("::" + position);
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    private class SampleViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView1;

        public SampleViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.textView3);
        }
    }
}
