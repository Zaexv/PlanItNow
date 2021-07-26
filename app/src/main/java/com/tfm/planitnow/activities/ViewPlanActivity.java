package com.tfm.planitnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tfm.planitnow.R;
import com.tfm.planitnow.models.Plan;
import com.tfm.planitnow.ui.home.HomeFragment;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class ViewPlanActivity extends AppCompatActivity {

    private TextView planTitle, planDescription, planDate, planSchedule, planLocation;
    private Button deletePlanButton;
    private ImageView planImageView;

    private Plan plan;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Configuration & getting Intent */
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        plan = (Plan) intent.getSerializableExtra("plan");

        setContentView(R.layout.activity_view_plan);

        initViews();
        setPlanToViews(plan);

    }

    public void deleteThisPlan(View view){
        HomeFragment.deletePlan(plan, getApplicationContext());
        this.finish();
    }

    private void initViews() {
        deletePlanButton = findViewById(R.id.view_plan_button_delete);
        if(true){ deletePlanButton.setVisibility(View.VISIBLE);} //TODO hacer que sólo lo pueda ver el dueño del plan
        planTitle = findViewById(R.id.view_plan_title);
        planDescription = findViewById(R.id.view_plan_description);
        planDate = findViewById(R.id.view_plan_date);
        planSchedule = findViewById(R.id.view_plan_schedule);
        planLocation = findViewById(R.id.view_plan_location);
        planImageView = findViewById(R.id.view_plan_image);
    }

    private void setPlanToViews(Plan plan) {
        planTitle.setText("" + plan.getTitle());
        planDescription.setText("" + plan.getDescription());
        Calendar c = Calendar.getInstance(); //TODO sacar utils de aqui
        c.setTime(plan.getInit_date());
        planDate.setText("" + c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH));
        planSchedule.setText("De " + plan.getInit_hour() + " a " + plan.getEnd_hour());
        planLocation.setText("" + plan.getLocation());
        if(plan.getMain_image_uri() != null) setImageUri(plan.getMain_image_uri());
    }

    public void setImageUri(String stringUri) {
        Uri uri = Uri.parse(stringUri);
        if(getApplicationContext().getContentResolver().getType(uri) != null);
            //planImageView.setImageURI(uri);
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}