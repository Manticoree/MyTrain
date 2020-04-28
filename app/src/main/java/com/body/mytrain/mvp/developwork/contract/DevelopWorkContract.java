package com.body.mytrain.mvp.developwork.contract;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

public interface DevelopWorkContract {
    interface IDevelopWorkPresenter{

    }

    interface IDevelopWorkView {
        void createGyroscopeControl(PanoramaImageView imageView);
        void createCustomSwitcher();
    }
}
