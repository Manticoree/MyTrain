package com.body.mytrain.entities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.body.mytrain.R;
import com.body.mytrain.constant.AppConstant;
import com.body.mytrain.mvp.developwork.view.DevelopWorkActivity;
import com.body.mytrain.mvp.gymdif.view.GymDiffActivity;
import com.body.mytrain.mvp.trainhomeprogram.view.TrainHomeActivity;
import com.body.mytrain.mvp.trainjogprogram.view.TrainJogProgramActivity;
import com.body.mytrain.mvp.trainstreetprogram.view.TrainStreetProgramActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;

public class TrainElement extends AbstractFlexibleItem<TrainElement.MyViewHolder> {

    private Context mContext;

    private String id;
    private int title;
    private int uri;

    private Bundle bundle = null;


    public TrainElement(String id, int title, int uri, Context mContext) {
        this.id = id;
        this.title = title;
        this.uri = uri;
        this.mContext = mContext;
    }

    @Override
    public boolean equals(Object inObject) {
        if (inObject instanceof TrainElement) {
            TrainElement inItem = (TrainElement) inObject;
            return this.id.equals(inItem.id);
        }
        return false;
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.train_item;
    }

    @Override
    public MyViewHolder createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new MyViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, MyViewHolder holder,
                               int position,
                               List<Object> payloads) {

        holder.tvTitle.setText(title);
        Picasso.get()
                .load(uri)
                .into(holder.ivTrain);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position == AppConstant.ZERO){
                    goToGymActivity();
                } else if(position == AppConstant.ONE){
                    goToStreetActivity(view);
                }else if(position == AppConstant.TWO){
                    goToHomeActivity(view);
                }else if(position == AppConstant.THREE){
                    goToJogActivity(view);
                }else if(position == AppConstant.FOUR){
                    goToTechnicalWorkActivity();
                }
            }
        });


    }

    public class MyViewHolder extends FlexibleViewHolder {
        public TextView tvTitle;
        public ImageView ivTrain;

        public MyViewHolder(View view, FlexibleAdapter adapter) {

            super(view, adapter);
            ivTrain = view.findViewById(R.id.ivPhotoTrain);
            tvTitle = view.findViewById(R.id.tvTitle);


        }


    }

    public void goToGymActivity() {
        Intent intent = new Intent(mContext, GymDiffActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
    public void goToStreetActivity(View view) {

transition(view);
        Intent intent = new Intent(mContext, TrainStreetProgramActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (bundle == null) {
            mContext.startActivity(intent);
        }else{
            mContext.startActivity(intent, bundle);
        }
    }
    public void goToHomeActivity(View view) {
        transition(view);
        Intent intent = new Intent(mContext, TrainHomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (bundle == null) {
            mContext.startActivity(intent);
        }else{
            mContext.startActivity(intent, bundle);
        }
    }
    public void goToJogActivity(View view) {
        transition(view);
        Intent intent = new Intent(mContext, TrainJogProgramActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (bundle == null) {
            mContext.startActivity(intent);
        }else{
            mContext.startActivity(intent, bundle);
        }
    }

    public void goToTechnicalWorkActivity() {
        Intent intent = new Intent(mContext, DevelopWorkActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    public void transition(View view){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            if(view != null){
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) mContext,
                        view,
                        mContext.getString(R.string.transition_train));
                bundle = options.toBundle();
            }
        }
    }

}
