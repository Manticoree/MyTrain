package com.body.mytrain.mvp.trainstreetprogram.contract;

import java.util.List;

import eu.davidea.flexibleadapter.items.IFlexible;

public interface TrainStreetProgramContract {
    interface ITrainStreetProgramPresenter{
        List<IFlexible>initDataOnRecyclerView1Level();
        List<IFlexible>initDataOnRecyclerView2Level();
        List<IFlexible>initDataOnRecyclerView3Level();
        List<IFlexible>initDataOnRecyclerView4Level();
    }

    interface ITrainStreetProgramView{

    }
}
