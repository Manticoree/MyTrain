package com.body.mytrain.mvp.trainprogram.presenter;

import com.body.mytrain.R;
import com.body.mytrain.entities.TrainProgramElement;
import com.body.mytrain.mvp.trainprogram.contract.TrainProgramContract;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.items.IFlexible;

public class TrainProgramPresenter implements TrainProgramContract.Presenter {
    @Override
    public void onWasClicked() {

    }

    @Override
    public List<IFlexible> initDataOnRecyclerView1Day() {
        List<IFlexible> firstDayTrainProgram = new ArrayList<>();
        firstDayTrainProgram.add(new TrainProgramElement("1", R.string.stretch, "10 мин"));
        firstDayTrainProgram.add(new TrainProgramElement("2", R.string.deadlift, "2x8"));
        firstDayTrainProgram.add(new TrainProgramElement("3", R.string.tilt_rod_pull, "3x8"));
        firstDayTrainProgram.add(new TrainProgramElement("4", R.string.wide_grip_pull_ups, "3х макс."));
        firstDayTrainProgram.add(new TrainProgramElement("5", R.string.barbell_lift, "2х12"));
        firstDayTrainProgram.add(new TrainProgramElement("6", R.string.press, "3 отказных сета"));
        firstDayTrainProgram.add(new TrainProgramElement("7", R.string.hitch, "10 мин"));
        return firstDayTrainProgram;
    }

    @Override
    public List<IFlexible> initDataOnRecyclerView2Day() {
        return null;
    }

    @Override
    public List<IFlexible> initDataOnRecyclerView3Day() {
        return null;
    }


    @Override
    public void onDestroy() {

    }
}
