package com.body.mytrain.gymdifmvp.presenter;

import com.body.mytrain.R;
import com.body.mytrain.entities.LevelElement;
import com.body.mytrain.entities.TrainElement;
import com.body.mytrain.gymdifmvp.contract.GYMDiffContract;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.items.IFlexible;

public class GYMDiffPresenter implements GYMDiffContract.PresenterGym {
    @Override
    public void onDifficultWasClicked() {

    }

    @Override
    public List<IFlexible> initDataOnRecyclerView() {
        List<IFlexible> diffGym = new ArrayList<>();
        diffGym.add(new LevelElement("1", R.string.noob, R.drawable.noob_in_gym));
        diffGym.add(new LevelElement("2", R.string.middle, R.drawable.middle_in_gym));
        diffGym.add(new LevelElement("3", R.string.high, R.drawable.high_in_gym));
        return diffGym;
    }

    @Override
    public void onDestroy() {

    }
}
