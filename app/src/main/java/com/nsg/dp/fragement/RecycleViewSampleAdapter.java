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
    private RecycleViewClickListener recycleViewClickListener;

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

    public void setClickListener(RecycleViewClickListener recycleViewClickListener) {
        this.recycleViewClickListener = recycleViewClickListener;
    }

    public void addItem(int i) {
        dataSet.add(i, "new Item" + i);
        notifyItemInserted(i);
//        notifyItemChanged(i);
    }

    public void removeItem(int i) {
        dataSet.remove(i);
        notifyItemRemoved(i);
//        notifyItemChanged(i);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.itemtext1);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            RecycleViewSampleAdapter.this.recycleViewClickListener.onItemClick(getPosition());
        }
    }

    public interface RecycleViewClickListener {
        void onItemClick(int position);
    }
}
