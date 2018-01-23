package com.poras.passionate.fragmentsexamples.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.poras.passionate.fragmentsexamples.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by purus on 1/22/2018.
 */

public class FragmentBodyPart extends Fragment {

    private static final String TAG = FragmentBodyPart.class.getSimpleName();
    private static final String IMAGE_LIST_IDS = "image_ids";
    private static final String LIST_INDEX = "list_index";

    private List<Integer> mImageIdList;
    private int mListIndex;

    public FragmentBodyPart() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mImageIdList = savedInstanceState.getIntegerArrayList(IMAGE_LIST_IDS);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View view = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.body_part);
        if (mImageIdList != null) {
            imageView.setImageResource(mImageIdList.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListIndex < mImageIdList.size() - 1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }

                    imageView.setImageResource(mImageIdList.get(mListIndex));
                }
            });

        }

        return view;
    }

    public void setImageIdList(List<Integer> mImageIdList) {
        this.mImageIdList = mImageIdList;
    }

    public void setListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(IMAGE_LIST_IDS, (ArrayList<Integer>) mImageIdList);
        outState.putInt(LIST_INDEX, mListIndex);
    }
}
