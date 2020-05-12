package com.body.mytrain.mvp.trainstreetprogram.view;

import android.os.Bundle;

import com.body.mytrain.R;
import com.body.mytrain.constant.AppConstant;
import com.body.mytrain.fragments.trainprogramfragment.gymfragment.AdapterTrainGymFragment;
import com.body.mytrain.mainclass.BaseActivity;
import com.body.mytrain.mvp.trainstreetprogram.contract.TrainStreetProgramContract;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TrainStreetProgramActivity extends BaseActivity
        implements TrainStreetProgramContract.ITrainStreetProgramView {
    @BindView(R.id.vpProgramTrainStreet)
    ViewPager vpProgramTrain;
    @BindView(R.id.tabDiffTrainStreet)
    TabLayout tabDiffTrain;

    private TrainStreetProgramContract.ITrainStreetProgramPresenter trainStreetProgramPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_street_layout);
        ButterKnife.bind(this);
        Bundle arguments = getIntent().getExtras();
       vpProgramTrain.setAdapter(new AdapterTrainGymFragment(getSupportFragmentManager(),
               TrainStreetProgramActivity.this, AppConstant.ZERO));
       tabDiffTrain.setupWithViewPager(vpProgramTrain);

    }
}
