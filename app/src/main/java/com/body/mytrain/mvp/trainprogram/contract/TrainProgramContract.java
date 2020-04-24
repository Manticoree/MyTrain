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

        List<IFlexible> initDataOnRecyclerView1DayNoob();
        List<IFlexible> initDataOnRecyclerView2DayNoob();
        List<IFlexible> initDataOnRecyclerView3DayNoob();

        List<IFlexible> initDataOnRecyclerView1DayMiddle();
        List<IFlexible> initDataOnRecyclerView2DayMiddle();
        List<IFlexible> initDataOnRecyclerView3DayMiddle();

        List<IFlexible> initDataOnRecyclerView1DayPro();
        List<IFlexible> initDataOnRecyclerView2DayPro();
        List<IFlexible> initDataOnRecyclerView3DayPro();

        void onDestroy();
    }
}
