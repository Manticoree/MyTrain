package com.body.mytrain.mvp.trainprogram.view;

import android.os.Bundle;

import com.body.mytrain.R;
import com.body.mytrain.entities.LevelElement;
import com.body.mytrain.mvp.trainprogram.contract.TrainProgramContract;
import com.body.mytrain.mvp.trainprogram.presenter.TrainProgramPresenter;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

public class TrainProgramActivity extends AppCompatActivity
        implements TrainProgramContract.View {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    @BindView(R.id.rvFirstDay)
    RecyclerView rvFirstDay;
    @BindView(R.id.rvSecondDay)
    RecyclerView rvSecondDay;
    @BindView(R.id.rvThirdDay)
    RecyclerView rvThirdDay;


    private TrainProgramContract.Presenter trainProgramPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_program_layout);
        ButterKnife.bind(this);
        trainProgramPresenter = new TrainProgramPresenter();
        Bundle arguments = getIntent().getExtras();
        int positionElement = (int) arguments.get(LevelElement.POSITION_ELEMENT);
        if(positionElement == ZERO) {
            showRecyclerView(rvFirstDay, trainProgramPresenter.initDataOnRecyclerView1DayNoob());
            showRecyclerView(rvSecondDay, trainProgramPresenter.initDataOnRecyclerView2DayNoob());
            showRecyclerView(rvThirdDay, trainProgramPresenter.initDataOnRecyclerView3DayNoob());

        } else if(positionElement == ONE){
            showRecyclerView(rvFirstDay, trainProgramPresenter.initDataOnRecyclerView1DayMiddle());
            showRecyclerView(rvSecondDay, trainProgramPresenter.initDataOnRecyclerView2DayMiddle());
            showRecyclerView(rvThirdDay, trainProgramPresenter.initDataOnRecyclerView3DayMiddle());
        } else if(positionElement == TWO){

        }


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
