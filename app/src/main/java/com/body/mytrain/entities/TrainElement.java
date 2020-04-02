package com.body.mytrain.entities;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.body.mytrain.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;

public class TrainElement extends AbstractFlexibleItem<TrainElement.MyViewHolder> {

    private String id;
    private String title;
    private int uri;


    public TrainElement(String id, String title, int uri) {
        this.id = id;
        this.title = title;
        this.uri = uri;
    }

    @Override
    public boolean equals(Object inObject) {
        if(inObject instanceof TrainElement) {
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
}
