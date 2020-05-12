package com.body.mytrain.mvp.trainstreetprogram.contract;

import java.util.List;

import eu.davidea.flexibleadapter.items.IFlexible;

public interface TrainStreetProgramContract {
    interface ITrainStreetProgramPresenter{
        List<IFlexible>initDataOnRecyclerView1Level();
    }

    interface ITrainStreetProgramView{

    }
}
