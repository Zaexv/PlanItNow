package com.tfm.planitnow.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tfm.planitnow.R;

public class PlanHolder extends RecyclerView.ViewHolder {
    private TextView planTitle;
    private TextView planDescription;
    private TextView planLocation;


    /* Constructor */
    public PlanHolder(View planItemView) {
        super(planItemView);

        planTitle = planItemView.findViewById(R.id.planTitleTextView);
        planDescription = planItemView.findViewById(R.id.planDescriptionTextView);
        planLocation = planItemView.findViewById(R.id.planLocationTextView);
    }

    /* Functions */

    public void setPlanTitle(String title){
        planTitle.setText(title);
    }

    public void setPlanDescription(String description){
        planDescription.setText(description);
    }

    public void setPlanLocation(String location){
        planLocation.setText(location);
    }

}


