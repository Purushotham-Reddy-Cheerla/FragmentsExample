package com.poras.passionate.fragmentsexamples.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.poras.passionate.fragmentsexamples.R;
import com.poras.passionate.fragmentsexamples.data.AndroidImageAssets;

public class DisplayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Bundle data = getIntent().getExtras();

        if (savedInstanceState == null) {
            FragmentBodyPart headFragment = new FragmentBodyPart();
            headFragment.setImageIdList(AndroidImageAssets.getHeads());
            assert data != null;
            headFragment.setListIndex(data.getInt("headIndex"));
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            FragmentBodyPart bodyFragment = new FragmentBodyPart();
            bodyFragment.setImageIdList(AndroidImageAssets.getBodies());
            bodyFragment.setListIndex(data.getInt("bodyIndex"));
            manager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            FragmentBodyPart legFragment = new FragmentBodyPart();
            legFragment.setImageIdList(AndroidImageAssets.getLegs());
            legFragment.setListIndex(data.getInt("legIndex"));
            manager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();

        }
    }
}
