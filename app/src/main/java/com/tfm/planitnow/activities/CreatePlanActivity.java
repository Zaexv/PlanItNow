package com.tfm.planitnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.tfm.planitnow.R;
import com.tfm.planitnow.adapters.PlanAdapter;
import com.tfm.planitnow.models.Plan;
import com.tfm.planitnow.ui.home.HomeFragment;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CreatePlanActivity extends AppCompatActivity {

    private TextView planTitle, planDescription, planLocation,planInitHour, planEndHour;
    private CalendarView planCalendar;
    private Calendar selectedInitCalendar;

    private Button createPlanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_create_plan);

        planTitle = findViewById(R.id.view_cp_title);
        planDescription = findViewById(R.id.view_cp_description);
        planLocation = findViewById(R.id.view_cp_location);
        planInitHour = findViewById(R.id.view_cp_init_hour);
        planEndHour = findViewById(R.id.view_cp_end_hour);
        createPlanButton = findViewById(R.id.view_cp_button);
        planCalendar = findViewById(R.id.calendarView);
        planCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){ //TODO -> Extraer como listener
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                selectedInitCalendar = new GregorianCalendar( year, month, dayOfMonth);
            }
        });

    }

    public void createPlan(View view){
        Random rn = new Random(); // TODO eliminar cuando tenga bien puesto los ints
        Plan p = new Plan(rn.nextInt(), planTitle.getText().toString(), planDescription.getText().toString(), planLocation.getText().toString());
        p.setInit_date(selectedInitCalendar.getTime());
        p.setInit_hour(Integer.parseInt(planInitHour.getText().toString()));
        p.setEnd_hour(Integer.parseInt(planEndHour.getText().toString()));
        Toast.makeText(view.getContext(), p.toString() , Toast.LENGTH_LONG).show();

        HomeFragment.addPlan(p);
        finish();
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