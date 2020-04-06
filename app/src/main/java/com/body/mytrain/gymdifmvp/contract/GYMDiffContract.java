package com.body.mytrain.gymdifmvp.contract;

public interface GYMDiffContract {
    interface ViewGym {
        void showRecyclerView();
    }

    interface PresenterGym {
        void onDifficultWasClicked();

        void initDataOnRecyclerView();
    }

}
