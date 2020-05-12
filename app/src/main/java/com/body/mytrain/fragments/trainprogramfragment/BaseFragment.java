package com.body.mytrain.fragments.trainprogramfragment;

import com.body.mytrain.mvp.trainprogram.contract.TrainProgramContract;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

public class BaseFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    public void showRecyclerView(RecyclerView recView,
                                 List<IFlexible> initList) {
        recView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,
                false);
        recView.setLayoutManager(manager);
        List<IFlexible> myItems = initList;
        FlexibleAdapter<IFlexible> adapter = new FlexibleAdapter<>(myItems);
        adapter.addListener(this);
        recView.setAdapter(adapter);
    }
}
