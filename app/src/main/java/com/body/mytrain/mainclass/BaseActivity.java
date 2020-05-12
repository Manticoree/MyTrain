package com.body.mytrain.mainclass;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

public class BaseActivity extends AppCompatActivity {
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
