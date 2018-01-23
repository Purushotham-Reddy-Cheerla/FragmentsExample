package com.poras.passionate.fragmentsexamples.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.poras.passionate.fragmentsexamples.R;
import com.poras.passionate.fragmentsexamples.data.AndroidImageAssets;

/**
 * Created by purus on 1/22/2018.
 */

public class MasterListFragment extends Fragment {

    private OnImageClickHandler mHandler;

    public interface OnImageClickHandler {
        void onImageSelected(int selectedImage);
    }

    public MasterListFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mHandler = (OnImageClickHandler) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnImageClickHandler");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.gridView);

        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mHandler.onImageSelected(position);
            }
        });

        return view;
    }
}
