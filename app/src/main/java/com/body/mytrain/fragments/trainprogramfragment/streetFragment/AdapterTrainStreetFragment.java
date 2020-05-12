package com.body.mytrain.fragments.trainprogramfragment.streetFragment;

import android.content.Context;

import com.body.mytrain.constant.AppConstant;
import com.body.mytrain.fragments.trainprogramfragment.gymfragment.TrainThreeFragment;
import com.body.mytrain.fragments.trainprogramfragment.gymfragment.TrainTwoFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdapterTrainStreetFragment extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] {AppConstant.FIRST_DAY,
            AppConstant.SECOND_DAY, AppConstant.THIRD_DAY };
    private Context context;
    private int diffPosition;

    public AdapterTrainStreetFragment(@NonNull FragmentManager fm, int behavior,
                                      Context context, int diffPosition) {
        super(fm, behavior);
        this.context = context;
        this.diffPosition = diffPosition;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0) {
            return TrainOneStreetFragment.newInstance(position + 1, diffPosition);
        }else if(position == 1){
            return TrainTwoFragment.newInstance(position + 1, diffPosition);
        }else{
            return TrainThreeFragment.newInstance(position + 1, diffPosition);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
