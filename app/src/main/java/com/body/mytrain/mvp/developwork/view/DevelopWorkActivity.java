package com.body.mytrain.mvp.developwork.view;

import android.graphics.Color;
import android.os.Bundle;

import com.body.mytrain.R;
import com.body.mytrain.constant.AppConstant;
import com.body.mytrain.mvp.developwork.contract.DevelopWorkContract;
import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;
import com.sdsmdg.harjot.rotatingtext.RotatingTextWrapper;
import com.sdsmdg.harjot.rotatingtext.models.Rotatable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DevelopWorkActivity extends AppCompatActivity implements DevelopWorkContract.IDevelopWorkView {

    @BindView(R.id.panoram_technical_work)
    PanoramaImageView panTechWork;
    @BindView(R.id.custom_switcher_technical_works)
    RotatingTextWrapper customSwitcherTechnicalWorks;

    private GyroscopeObserver gyroscopeObserver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.develop_work_layout);
        ButterKnife.bind(this);
        createGyroscopeControl(panTechWork);
        createCustomSwitcher();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gyroscopeObserver.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gyroscopeObserver.unregister();
    }


    @Override
    public void createGyroscopeControl(PanoramaImageView imageView) {
        gyroscopeObserver = new GyroscopeObserver();
        gyroscopeObserver.setMaxRotateRadian(Math.PI / 9);
        imageView.setGyroscopeObserver(gyroscopeObserver);
        imageView.setOnPanoramaScrollListener(new PanoramaImageView.OnPanoramaScrollListener() {
            @Override
            public void onScrolled(PanoramaImageView view, float offsetProgress) {
                // Do something here.
                // The offsetProgress range from -1 to 1, indicating the image scrolls
                // from left(top) to right(bottom).
            }
        });
    }

    @Override
    public void createCustomSwitcher() {
        customSwitcherTechnicalWorks.setSize(35);
        Rotatable rotatable = new Rotatable(Color.parseColor("#FFA036"), 1000,
                AppConstant.developWorks, AppConstant.seeYouSoon);
        rotatable.setSize(35);
        rotatable.setAnimationDuration(500);
        customSwitcherTechnicalWorks.setContent("erg ?", rotatable);

    }


}
