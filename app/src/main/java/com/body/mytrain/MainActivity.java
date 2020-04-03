package com.body.mytrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

import android.os.Bundle;

import com.body.mytrain.entities.TrainElement;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rvSportLists)
    RecyclerView rvListTrain;

    private FlexibleAdapter<IFlexible> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
        list.add(new TrainElement("1", "Тренировка в зале", R.drawable.woman_in_gym));
        list.add(new TrainElement("2", "Тренировка на улице", R.drawable.train_in_street));
        list.add(new TrainElement("3", "Тренировка на площадке", R.drawable.train_on_workout));
        list.add(new TrainElement("4", "Тренировка дома", R.drawable.home_train));
        list.add(new TrainElement("5", "Занятие йогой", R.drawable.train_jog));
        return list;
    }



}
