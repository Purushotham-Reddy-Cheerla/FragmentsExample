package com.poras.passionate.fragmentsexamples.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by purus on 1/22/2018.
 */

public class MasterListAdapter extends BaseAdapter {

    private List<Integer> mImageIdList;
    private Context mContext;

    public MasterListAdapter(Context context, List<Integer> list) {
        this.mImageIdList = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mImageIdList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mImageIdList.get(position));
        return imageView;
    }
}
