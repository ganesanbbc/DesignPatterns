package com.nsg.dp.multirecycleview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by varshika on 31/07/16.
 */
public class CustomPageAdapter extends PagerAdapter {

    private android.content.Context context;

    public CustomPageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView textView = new TextView(context);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(30);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText(String.valueOf(position));
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(layoutParams);
        layout.addView(textView);

        container.addView(layout);
        return layout;


    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}


