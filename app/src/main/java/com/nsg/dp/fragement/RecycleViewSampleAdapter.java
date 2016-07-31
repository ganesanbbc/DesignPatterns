package com.nsg.dp.fragement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nsg.dp.R;

import java.util.List;

/**
 * Created by varshika on 31/07/16.
 */
public class RecycleViewSampleAdapter extends RecyclerView.Adapter<RecycleViewSampleAdapter.MyViewHolder> {

    private List<String> dataSet;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycleview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setDataSet(List<String> dataSet) {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.itemtext1);
        }


    }

}
