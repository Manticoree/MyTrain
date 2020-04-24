package com.body.mytrain.entities;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.body.mytrain.R;
import com.body.mytrain.mvp.gymdif.view.GymDiffActivity_ViewBinding;
import com.body.mytrain.mvp.trainprogram.view.TrainProgramActivity;
import com.body.mytrain.mvp.trainprogram.view.TrainProgramActivity_ViewBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;

public class LevelElement extends AbstractFlexibleItem<LevelElement.MyViewHolder> {

    public static final String POSITION_ELEMENT =  "positionElement";

    private Context mContext;

    private String id;
    private int title;
    private int uri;

    private int positionElement;


    public LevelElement(String id, int title, int uri, Context mContext) {
        this.id = id;
        this.title = title;
        this.uri = uri;
        this.mContext = mContext;
    }

    @Override
    public boolean equals(Object inObject) {
        if(inObject instanceof LevelElement) {
            LevelElement inItem = (LevelElement) inObject;
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
        return R.layout.level_item;
    }

    @Override
    public LevelElement.MyViewHolder createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new LevelElement.MyViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, LevelElement.MyViewHolder holder,
                               int position,
                               List<Object> payloads) {

        holder.tvTitle.setText(title);
        Picasso.get()
                .load(uri)
                .into(holder.ivTrain);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
positionElement = position;
              //  if(position == 0){
                    goToTrainProgramActivity();
              //  }
            }
        });



    }

    public class MyViewHolder extends FlexibleViewHolder {
        public TextView tvTitle;
        public ImageView ivTrain;

        public MyViewHolder(View view, FlexibleAdapter adapter) {

            super(view, adapter);
            ivTrain = view.findViewById(R.id.ivPhotoTrainLevel);
            tvTitle = view.findViewById(R.id.tvLevelGrad);
        }


    }


    public void goToTrainProgramActivity() {
        Intent intent = new Intent(mContext, TrainProgramActivity.class);
        intent.putExtra(POSITION_ELEMENT, positionElement);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
