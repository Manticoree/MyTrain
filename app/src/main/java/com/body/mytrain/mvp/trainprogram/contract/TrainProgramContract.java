package com.body.mytrain.mvp.trainprogram.contract;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

public interface TrainProgramContract {
    interface View {

        void showRecyclerView(RecyclerView recView,  List<IFlexible> initList);

    }

    interface Presenter {
        void onWasClicked();

        List<IFlexible> initDataOnRecyclerView1Day();
        List<IFlexible> initDataOnRecyclerView2Day();
        List<IFlexible> initDataOnRecyclerView3Day();

        void onDestroy();
    }
}
