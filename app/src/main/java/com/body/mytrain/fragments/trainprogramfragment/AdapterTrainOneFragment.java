package com.body.mytrain.fragments.trainprogramfragment;

import android.content.Context;

import com.body.mytrain.constant.AppConstant;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdapterTrainOneFragment extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] {AppConstant.FIRST_DAY,
            AppConstant.SECOND_DAY, AppConstant.THIRD_DAY };
    private Context context;
    private int diffPosition;

    public AdapterTrainOneFragment(@NonNull FragmentManager fm,
                                   Context context, int diffPosition) {
        super(fm);
        this.context = context;
        this.diffPosition = diffPosition;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if(position==0) {
            return TrainOneFragment.newInstance(position + 1, diffPosition);
        }else if(position == 1){
            return TrainTwoFragment.newInstance(position + 1, diffPosition);
        }else{
            return TrainThreeFragment.newInstance(position + 1, diffPosition);
        }
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

