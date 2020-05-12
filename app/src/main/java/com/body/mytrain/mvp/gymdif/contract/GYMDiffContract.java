package com.body.mytrain.mvp.gymdif.contract;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import eu.davidea.flexibleadapter.items.IFlexible;

public interface GYMDiffContract {
    interface ViewGym {
        void showRecyclerView(RecyclerView recView,
                              List<IFlexible> initList);
    }

    interface PresenterGym {
        void onDifficultWasClicked();

        List<IFlexible> initDataOnRecyclerView();

        void onDestroy();
    }

}
