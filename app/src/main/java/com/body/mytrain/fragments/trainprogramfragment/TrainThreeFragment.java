package com.body.mytrain.fragments.trainprogramfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.body.mytrain.R;
import com.body.mytrain.mvp.trainprogram.contract.TrainProgramContract;
import com.body.mytrain.mvp.trainprogram.presenter.TrainProgramPresenter;
import com.body.mytrain.mvp.trainprogram.view.TrainProgramActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

public class TrainThreeFragment extends TrainFragment {
    @BindView(R.id.rvFirstDay)
    RecyclerView rvFirstDay;
    @BindView(R.id.rvSecondDay)
    RecyclerView rvSecondDay;
    @BindView(R.id.rvThirdDay)
    RecyclerView rvThirdDay;

    private TrainProgramContract.Presenter trainProgramPresenter;
    private int mPage;
    private static int position;

    public static TrainThreeFragment newInstance(int page, int diffPosition) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TrainThreeFragment fragment = new TrainThreeFragment();
        fragment.setArguments(args);
        position = diffPosition;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trainProgramPresenter = new TrainProgramPresenter();

        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.train_fragment, container, false);
        ButterKnife.bind(this, view);
        if (position == TrainProgramActivity.ZERO) {
            showRecyclerView(rvFirstDay, trainProgramPresenter.initDataOnRecyclerView3DayNoob());
        } else if (position == TrainProgramActivity.ONE) {
            showRecyclerView(rvFirstDay, trainProgramPresenter.initDataOnRecyclerView3DayMiddle());
        } else if (position == TrainProgramActivity.TWO) {
            showRecyclerView(rvFirstDay, trainProgramPresenter.initDataOnRecyclerView3DayPro());
        }

        return view;
    }



}