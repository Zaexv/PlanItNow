package com.tfm.planitnow.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tfm.planitnow.R;

public class PlanHolder extends RecyclerView.ViewHolder {
    private TextView planName;
    private TextView planDescription;
    private TextView planLocation;


    /* Constructor */
    public PlanHolder(View planItemView) {
        super(planItemView);

        planName = planItemView.findViewById(R.id.planNameTextView);
        planDescription = planItemView.findViewById(R.id.planDescriptionTextView);
        planLocation = planItemView.findViewById(R.id.planLocationTextView);
    }

    /* Functions */

    public void setPlanName(String name){
        planName.setText(name);
    }

    public void setPlanDescription(String description){
        planDescription.setText(description);
    }

    public void setPlanLocation(String location){
        planLocation.setText(location);
    }

}


