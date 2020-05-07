package com.body.mytrain.mvp.trainstreetprogram.view;

import android.os.Bundle;

import com.body.mytrain.R;
import com.body.mytrain.mvp.trainstreetprogram.contract.TrainStreetProgramContract;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class TrainStreetProgramActivity extends AppCompatActivity
        implements TrainStreetProgramContract.ITrainStreetProgramView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_street_layout);
        ButterKnife.bind(this);
    }
}
