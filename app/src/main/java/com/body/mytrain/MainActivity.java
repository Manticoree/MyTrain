package com.body.mytrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

import android.content.Context;
import android.os.Bundle;

import com.body.mytrain.entities.TrainElement;
import com.body.mytrain.entities.bd.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {


    @BindView(R.id.rvSportLists)
    RecyclerView rvListTrain;

    private FlexibleAdapter<IFlexible> mAdapter;
    private AppDatabase persondb;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_sport_layout);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        persondb = Room.databaseBuilder(mContext, AppDatabase.class, "person-database")
                .build();
        getFlexibleAdapter();
    }


    private void getFlexibleAdapter() {
        rvListTrain.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,
                GridLayoutManager.VERTICAL, false);
        rvListTrain.setLayoutManager(manager);
        List<IFlexible> myItems = getDatabaseList();
        mAdapter = new FlexibleAdapter<>(myItems);
        mAdapter.addListener(this);
        rvListTrain.setAdapter(mAdapter);
    }



    public List<IFlexible> getDatabaseList() {
        List<IFlexible> list = new ArrayList<>();
        list.add(new TrainElement( "1", R.string.train_in_gym, R.drawable.woman_in_gym, mContext));
        list.add(new TrainElement("2", R.string.train_in_street, R.drawable.train_in_street, mContext));
        list.add(new TrainElement("3", R.string.train_on_workout, R.drawable.train_on_workout, mContext));
        list.add(new TrainElement("4", R.string.home_train, R.drawable.home_train, mContext));
        list.add(new TrainElement("5", R.string.train_jog, R.drawable.train_jog, mContext));
        return list;
    }



}
