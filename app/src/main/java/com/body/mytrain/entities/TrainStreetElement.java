package com.body.mytrain.entities;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.body.mytrain.R;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;

public class TrainStreetElement extends AbstractFlexibleItem<TrainStreetElement.MyViewHolder> {

    private Context mContext;

    private String id;
    private String exercices;
    private String number;

    public TrainStreetElement(String id, String exercices, String number) {
        this.id = id;
        this.exercices = exercices;
        this.number = number;
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof TrainStreetElement) {
            TrainStreetElement inItem = (TrainStreetElement) o;
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
        return R.layout.train_program_item;
    }

    @Override
    public TrainStreetElement.MyViewHolder createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new MyViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, TrainStreetElement.MyViewHolder holder,
                               int position, List<Object> payloads) {
        holder.exercice.setText(exercices);
        holder.number.setText(number);
    }

    public class MyViewHolder extends FlexibleViewHolder {
        public TextView exercice;
        public TextView number;

        public MyViewHolder(View view, FlexibleAdapter adapter) {

            super(view, adapter);
            exercice = view.findViewById(R.id.tvTrainEx);
            number = view.findViewById(R.id.tvTrainNumber);


        }
    }


}
