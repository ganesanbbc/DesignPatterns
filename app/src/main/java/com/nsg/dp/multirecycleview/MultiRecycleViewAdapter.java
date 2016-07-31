package com.nsg.dp.multirecycleview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nsg.dp.R;

/**
 * Created by varshika on 31/07/16.
 */
public class MultiRecycleViewAdapter extends RecyclerView.Adapter<MultiRecycleViewAdapter.MultiRecycleViewHolder> {

    Context context;
    private CustomPageAdapter customPageAdapter;

    public MultiRecycleViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MultiRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MultiRecycleViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.multi_recycleview_item, parent, false));
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(final MultiRecycleViewHolder holder, int position) {
        holder.viewpager.setAdapter(customPageAdapter);
    }

    @Override
    public int getItemCount() {
        return 2;
    }


    public void setPageAdapter(CustomPageAdapter customPageAdapter) {
        this.customPageAdapter = customPageAdapter;
    }

    /**
     * Created by varshika on 31/07/16.
     */
    public static class MultiRecycleViewHolder extends RecyclerView.ViewHolder {
        private final ViewPager viewpager;

        public MultiRecycleViewHolder(View itemView) {
            super(itemView);
            viewpager = (ViewPager) itemView.findViewById(R.id.viewpager);
        }
    }

}
