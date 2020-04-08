package com.body.mytrain.mvp.gymdif.contract;

import java.util.List;

import eu.davidea.flexibleadapter.items.IFlexible;

public interface GYMDiffContract {
    interface ViewGym {
        void showRecyclerView();
    }

    interface PresenterGym {
        void onDifficultWasClicked();

        List<IFlexible> initDataOnRecyclerView();

        void onDestroy();
    }

}