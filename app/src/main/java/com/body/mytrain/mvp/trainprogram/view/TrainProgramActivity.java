package com.body.mytrain.mvp.trainprogram.view;

import android.os.Bundle;

import com.body.mytrain.R;
import com.body.mytrain.constant.AppConstant;
import com.body.mytrain.entities.LevelElement;
import com.body.mytrain.fragments.trainprogramfragment.gymfragment.AdapterTrainGymFragment;
import com.body.mytrain.mainclass.BaseActivity;
import com.body.mytrain.mvp.trainprogram.contract.TrainProgramContract;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TrainProgramActivity extends BaseActivity
        implements TrainProgramContract.View {


    @BindView(R.id.vpProgramTrain)
    ViewPager vpProgramTrain;
    @BindView(R.id.tabDiffTrain)
    TabLayout tabDiffTrain;


    private TrainProgramContract.Presenter trainProgramPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_program_layout);
        ButterKnife.bind(this);
       // trainProgramPresenter = new TrainProgramPresenter();
        Bundle arguments = getIntent().getExtras();
        int positionElement = (int) arguments.get(LevelElement.POSITION_ELEMENT);

        if(positionElement == AppConstant.ZERO) {
            vpProgramTrain.setAdapter(new AdapterTrainGymFragment(getSupportFragmentManager(),
                    TrainProgramActivity.this, AppConstant.ZERO));

        }else if(positionElement == AppConstant.ONE) {
            vpProgramTrain.setAdapter(new AdapterTrainGymFragment(getSupportFragmentManager(),
                    TrainProgramActivity.this, AppConstant.ONE));
        }else if(positionElement == AppConstant.TWO){
            vpProgramTrain.setAdapter(new AdapterTrainGymFragment(getSupportFragmentManager(),
                    TrainProgramActivity.this, AppConstant.TWO));
        }

        tabDiffTrain.setupWithViewPager(vpProgramTrain);




    }





}
