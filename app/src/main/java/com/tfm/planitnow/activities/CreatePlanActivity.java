package com.tfm.planitnow.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tfm.planitnow.R;
import com.tfm.planitnow.database.PlanItNowDatabase;
import com.tfm.planitnow.models.Plan;
import com.tfm.planitnow.ui.home.HomeFragment;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Random;

public class CreatePlanActivity extends AppCompatActivity {

    private static final int SELECT_IMAGE = 200;

    private TextView planTitle, planDescription, planLocation, planInitHour, planEndHour;
    private CalendarView planCalendar;
    private ImageView imageButton;
    private Calendar selectedInitCalendar;
    private Uri imageUri;

    private Button createPlanButton;
    private ActivityResultLauncher<Intent> galleryActivityResultLauncher;

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
        imageButton = findViewById(R.id.view_cp_add_image);
        selectedInitCalendar = Calendar.getInstance();

        /* Adding Actions */
        planCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){ //TODO -> Extraer como listener
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                selectedInitCalendar = new GregorianCalendar(year, month, dayOfMonth);
            }
        });
        galleryActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                            imageUri = data.getData();
                            imageButton.setImageURI(imageUri);
                        }
                    }
                });
    }

    public void createPlan(View view){
        Random rn = new Random(); // TODO eliminar cuando tenga bien puesto los ints
        Plan p = new Plan(rn.nextInt(), planTitle.getText().toString(), planDescription.getText().toString(), planLocation.getText().toString());
        p.setInit_date(selectedInitCalendar.getTime());
        p.setInit_hour(Integer.parseInt(planInitHour.getText().toString()));
        p.setEnd_hour(Integer.parseInt(planEndHour.getText().toString()));
        if(imageUri != null) p.setMain_image_uri(imageUri.toString());
        if(p.isValid()) {
            Toast.makeText(view.getContext(), p.toString(), Toast.LENGTH_LONG).show();
            PlanItNowDatabase.getInstance(getApplicationContext()).planDao().insertAll(p);
            HomeFragment.addPlan(p);
            finish();
        } else {
            Toast.makeText(view.getContext(), "El plan no es valido. Hora entre 00 y 24 o fecha anterior a hoy.", Toast.LENGTH_LONG).show();
        }

    }

    public void openGalleryForResult(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
        galleryActivityResultLauncher.launch(intent);
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