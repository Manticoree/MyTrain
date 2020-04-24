package com.body.mytrain.entities;

import android.content.Context;
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

public class AnotherTrainElement extends AbstractFlexibleItem<AnotherTrainElement.MyViewHolder> {

    private Context mContext;

    private String id;
    private int title;
    private int uri;

    public AnotherTrainElement(String id, int title, int uri, Context mContext) {
        this.mContext = mContext;
        this.id = id;
        this.title = title;
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof AnotherTrainElement) {
            AnotherTrainElement inItem = (AnotherTrainElement) o;
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
        return R.layout.another_train_item;
    }

    @Override
    public MyViewHolder createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new MyViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, MyViewHolder holder, int position, List<Object> payloads) {

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
            ivTrain = view.findViewById(R.id.ivAnotherPhoto);
            tvTitle = view.findViewById(R.id.tvAnotherTitle);

        }
    }

    public void goToRunActivity() {

    }
}
