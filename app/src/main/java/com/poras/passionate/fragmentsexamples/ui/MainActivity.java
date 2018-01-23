package com.poras.passionate.fragmentsexamples.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.poras.passionate.fragmentsexamples.R;
import com.poras.passionate.fragmentsexamples.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickHandler {
    private int mHeadIndex;
    private int mBodyIndex;
    private int mLegIndex;

    private boolean mDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.android_dual_container) != null) {
            mDualPane = true;

            Button nxtButton = findViewById(R.id.btn_next);
            nxtButton.setVisibility(View.GONE);
            GridView gridView = findViewById(R.id.gridView);
            gridView.setNumColumns(2);

            if (savedInstanceState == null) {
                FragmentBodyPart headFragment = new FragmentBodyPart();
                headFragment.setImageIdList(AndroidImageAssets.getHeads());
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .commit();

                FragmentBodyPart bodyFragment = new FragmentBodyPart();
                bodyFragment.setImageIdList(AndroidImageAssets.getBodies());
                manager.beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit();

                FragmentBodyPart legFragment = new FragmentBodyPart();
                legFragment.setImageIdList(AndroidImageAssets.getLegs());
                manager.beginTransaction()
                        .add(R.id.leg_container, legFragment)
                        .commit();

            }

        } else {
            mDualPane = false;
        }

    }

    @Override
    public void onImageSelected(int selectedImage) {
        int bodyPartNumber = selectedImage / 12;
        int listIndex = selectedImage - 12 * bodyPartNumber;


        if (mDualPane) {
            FragmentBodyPart fragmentBodyPart = new FragmentBodyPart();
            switch (bodyPartNumber) {
                case 0:
                    fragmentBodyPart.setListIndex(listIndex);
                    fragmentBodyPart.setImageIdList(AndroidImageAssets.getHeads());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, fragmentBodyPart)
                            .commit();
                    break;
                case 1:
                    fragmentBodyPart.setListIndex(listIndex);
                    fragmentBodyPart.setImageIdList(AndroidImageAssets.getBodies());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, fragmentBodyPart)
                            .commit();
                    break;
                case 2:
                    fragmentBodyPart.setListIndex(listIndex);
                    fragmentBodyPart.setImageIdList(AndroidImageAssets.getLegs());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, fragmentBodyPart)
                            .commit();
                    break;
                default:
                    break;

            }
        } else {
            switch (bodyPartNumber) {
                case 0:
                    mHeadIndex = listIndex;
                    break;
                case 1:
                    mBodyIndex = listIndex;
                    break;
                case 2:
                    mLegIndex = listIndex;
                    break;
                default:
                    break;
            }
        }


        Bundle bundle = new Bundle();
        bundle.putInt("headIndex", mHeadIndex);
        bundle.putInt("bodyIndex", mBodyIndex);
        bundle.putInt("legIndex", mLegIndex);

        final Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtras(bundle);


        Button nextButton = (Button) findViewById(R.id.btn_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
}
