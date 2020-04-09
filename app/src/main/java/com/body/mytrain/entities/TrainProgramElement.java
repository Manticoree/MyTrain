package com.body.mytrain.entities;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.body.mytrain.R;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;

public class TrainProgramElement extends AbstractFlexibleItem<TrainProgramElement.MyViewHolder> {

    private Context mContext;

    private String id;
    private int exercices;
    private String number;

    public TrainProgramElement(String id, int exercices, String number) {
        this.id = id;
        this.exercices = exercices;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TrainProgramElement) {
            TrainProgramElement inItem = (TrainProgramElement) o;
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
    public MyViewHolder createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new MyViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, MyViewHolder holder,
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
