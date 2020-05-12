package com.body.mytrain.fragments.trainprogramfragment.streetFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.body.mytrain.R;
import com.body.mytrain.constant.AppConstant;
import com.body.mytrain.fragments.trainprogramfragment.BaseFragment;
import com.body.mytrain.mvp.trainstreetprogram.contract.TrainStreetProgramContract;
import com.body.mytrain.mvp.trainstreetprogram.presenter.TrainStreetProgramPresenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TrainOneStreetFragment extends BaseFragment {
    @BindView(R.id.rvFirstDay)
    RecyclerView rvFirstDay;

    private TrainStreetProgramContract.ITrainStreetProgramPresenter trainStreetProgramPresenter;
    private int mPage;
    private static int position;

    public static TrainOneStreetFragment newInstance(int page, int diffPosition) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TrainOneStreetFragment fragment = new TrainOneStreetFragment();
        fragment.setArguments(args);
        position = diffPosition;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trainStreetProgramPresenter = new TrainStreetProgramPresenter();

        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.train_fragment, container, false);
        ButterKnife.bind(this, view);
        if (position == AppConstant.ZERO) {
            showRecyclerView(rvFirstDay, trainStreetProgramPresenter.initDataOnRecyclerView1Level());
        } else if (position == AppConstant.ONE) {
            //showRecyclerView(rvFirstDay, trainProgramPresenter.initDataOnRecyclerView1DayMiddle());
        } else if (position == AppConstant.TWO) {
           // showRecyclerView(rvFirstDay, trainProgramPresenter.initDataOnRecyclerView1DayPro());
        }

        return view;
    }
}