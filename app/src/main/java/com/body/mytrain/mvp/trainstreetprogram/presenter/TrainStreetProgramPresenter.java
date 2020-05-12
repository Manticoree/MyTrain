package com.body.mytrain.mvp.trainstreetprogram.presenter;

import com.body.mytrain.R;
import com.body.mytrain.entities.TrainProgramElement;
import com.body.mytrain.mvp.trainstreetprogram.contract.TrainStreetProgramContract;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.items.IFlexible;

public class TrainStreetProgramPresenter implements TrainStreetProgramContract.ITrainStreetProgramPresenter {



    @Override
    public List<IFlexible> initDataOnRecyclerView1Level() {
        List<IFlexible> firstDayTrainProgram = new ArrayList<>();
        firstDayTrainProgram.add(new TrainProgramElement("1",R.string.stretch, "10 мин"));
      //  firstDayTrainProgram.add(new TrainProgramElement("2", "Отжимания с колен", "2x8"));
       // firstDayTrainProgram.add(new TrainProgramElement("3", "", "3x8"));
        firstDayTrainProgram.add(new TrainProgramElement("4", R.string.wide_grip_pull_ups, "3х макс."));
        firstDayTrainProgram.add(new TrainProgramElement("5", R.string.barbell_lift, "2х12"));
        firstDayTrainProgram.add(new TrainProgramElement("6", R.string.press, "3 отказных сета"));
        firstDayTrainProgram.add(new TrainProgramElement("7", R.string.hitch, "10 мин"));
        return firstDayTrainProgram;
    }


}
