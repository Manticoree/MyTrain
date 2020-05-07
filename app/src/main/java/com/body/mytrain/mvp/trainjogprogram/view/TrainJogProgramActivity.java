package com.body.mytrain.mvp.trainjogprogram.view;

import android.os.Bundle;

import com.body.mytrain.R;
import com.body.mytrain.mvp.trainjogprogram.contract.TrainJogProgramContract;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class TrainJogProgramActivity extends AppCompatActivity implements TrainJogProgramContract.View {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_jog_layout);
        ButterKnife.bind(this);
    }
}
