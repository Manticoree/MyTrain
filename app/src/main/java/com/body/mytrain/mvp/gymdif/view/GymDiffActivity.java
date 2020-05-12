package com.body.mytrain.mvp.gymdif.view;

import android.content.Context;
import android.os.Bundle;

import com.body.mytrain.R;
import com.body.mytrain.mainclass.BaseActivity;
import com.body.mytrain.mvp.gymdif.contract.GYMDiffContract;
import com.body.mytrain.mvp.gymdif.presenter.GYMDiffPresenter;
import com.r0adkll.slidr.Slidr;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

public class GymDiffActivity extends BaseActivity implements GYMDiffContract.ViewGym {

    @BindView(R.id.rvDiffGym)
    RecyclerView rvDiffGym;

    private GYMDiffContract.PresenterGym mPresenterGYM;
    private FlexibleAdapter<IFlexible> mAdapter;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gym_train_layout);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        mPresenterGYM = new GYMDiffPresenter(mContext);
        showRecyclerView(rvDiffGym, mPresenterGYM.initDataOnRecyclerView());

        //todo сделать отдельный поток для слайдера
        /*
        int primary = getResources().getColor(R.color.colorPrimaryDark);
        int secondary = getResources().getColor(R.color.colorPrimary);
        Slidr.attach(this, primary, secondary);

         */
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenterGYM.onDestroy();
    }

}
