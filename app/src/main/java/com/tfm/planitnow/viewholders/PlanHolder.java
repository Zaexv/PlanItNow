package com.tfm.planitnow.viewholders;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.tfm.planitnow.R;
import com.tfm.planitnow.activities.MainActivity;
import com.tfm.planitnow.activities.ViewPlanActivity;
import com.tfm.planitnow.models.Plan;

import java.io.IOException;
import java.net.URI;

public class PlanHolder extends RecyclerView.ViewHolder {
    private TextView planTitle;
    private TextView planDescription;
    private TextView planLocation;
    private ImageView planImage;

    private Plan plan;
    private View planItemView;


    /* Constructor */
    public PlanHolder(View planItemView) {
        super(planItemView);
        this.planItemView = planItemView;


        //TODO Refactor
        planItemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int duration = Toast.LENGTH_LONG;
                Toast.makeText(itemView.getContext(), plan.getTitle(), duration ).show();
                Intent i = new Intent(planItemView.getContext(), ViewPlanActivity.class);
                i.putExtra("plan",plan);
                planItemView.getContext().startActivity(i);
            }
        });

        planTitle = planItemView.findViewById(R.id.planTitleTextView);
        planDescription = planItemView.findViewById(R.id.planDescriptionTextView);
        planLocation = planItemView.findViewById(R.id.planLocationTextView);
        planImage = planItemView.findViewById(R.id.planImageView);
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

    public void setImageUri(String stringUri) {
        Uri uri = Uri.parse(stringUri);
        if(planItemView.getContext().getContentResolver().getType(uri) != null);
         //   planImage.setImageURI(uri);
            }


    public void bindData(Plan plan){
        this.plan = plan;
        this.setPlanTitle(plan.getTitle());
        this.setPlanDescription(plan.getDescription());
        this.setPlanLocation(plan.getLocation());
        if(plan.getMain_image_uri() != null) this.setImageUri(plan.getMain_image_uri());
    }


}


