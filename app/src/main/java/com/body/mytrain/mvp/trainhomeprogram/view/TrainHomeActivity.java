package com.body.mytrain.mvp.trainhomeprogram.view;

import android.os.Bundle;

import com.body.mytrain.R;
import com.body.mytrain.mvp.trainhomeprogram.contract.TrainHomeProgramContract;
import com.body.mytrain.mvp.trainstreetprogram.contract.TrainStreetProgramContract;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class TrainHomeActivity extends AppCompatActivity implements TrainHomeProgramContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_home_layout);
        ButterKnife.bind(this);

    }
}
