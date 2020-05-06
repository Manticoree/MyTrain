package com.body.mytrain.mvp.trainprogram.view;

import android.os.Bundle;

import com.body.mytrain.R;
import com.body.mytrain.entities.LevelElement;
import com.body.mytrain.fragments.trainprogramfragment.AdapterTrainOneFragment;
import com.body.mytrain.mvp.trainprogram.contract.TrainProgramContract;
import com.body.mytrain.mvp.trainprogram.presenter.TrainProgramPresenter;
import com.google.android.material.tabs.TabLayout;
import com.r0adkll.slidr.Slidr;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

public class TrainProgramActivity extends AppCompatActivity
        implements TrainProgramContract.View {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    @BindView(R.id.vpProgramTrain)
    ViewPager vpProgramTrain;
    @BindView(R.id.tabDiffTrain)
    TabLayout tabDiffTrain;
/*
    @BindView(R.id.rvFirstDay)
    RecyclerView rvFirstDay;
    @BindView(R.id.rvSecondDay)
    RecyclerView rvSecondDay;
    @BindView(R.id.rvThirdDay)
    RecyclerView rvThirdDay;
*/

    private TrainProgramContract.Presenter trainProgramPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_program_layout);
        ButterKnife.bind(this);
       // trainProgramPresenter = new TrainProgramPresenter();
        Bundle arguments = getIntent().getExtras();
        int positionElement = (int) arguments.get(LevelElement.POSITION_ELEMENT);

        if(positionElement == ZERO) {
            vpProgramTrain.setAdapter(new AdapterTrainOneFragment(getSupportFragmentManager(),
                    TrainProgramActivity.this, ZERO));

        }else if(positionElement == ONE) {
            vpProgramTrain.setAdapter(new AdapterTrainOneFragment(getSupportFragmentManager(),
                    TrainProgramActivity.this, ONE));
        }else if(positionElement == TWO){
            vpProgramTrain.setAdapter(new AdapterTrainOneFragment(getSupportFragmentManager(),
                    TrainProgramActivity.this, TWO));
        }

        tabDiffTrain.setupWithViewPager(vpProgramTrain);




    }


    public void showRecyclerView(RecyclerView recView,
                                 List<IFlexible> initList) {
        recView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false);
        recView.setLayoutManager(manager);
        List<IFlexible> myItems = initList;
        FlexibleAdapter<IFlexible> adapter = new FlexibleAdapter<>(myItems);
        adapter.addListener(this);
        recView.setAdapter(adapter);
    }


}
