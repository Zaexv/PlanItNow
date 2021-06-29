package com.tfm.planitnow.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tfm.planitnow.R;
import com.tfm.planitnow.activities.CreatePlanActivity;
import com.tfm.planitnow.adapters.PlanAdapter;
import com.tfm.planitnow.models.Plan;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;
    private List<Plan> planList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        /*
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
         */

        test1_init(); //Just for testing purposes

        /* Init button */ //TODO Refactor
        FloatingActionButton fab = root.findViewById(R.id.goto_createplanbutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), CreatePlanActivity.class);
                root.getContext().startActivity(i);
            }
        });

        PlanAdapter planAdapter = new PlanAdapter(this.getContext(),planList);
        RecyclerView recyclerView = root.findViewById(R.id.listPlanRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(planAdapter);
        return root;
    }


    public void test1_init(){
        planList = new ArrayList<>();
        planList.add(new Plan(1, "Hacer música con Clau en el Piso", "De 18:00 a 19:00","El pisito"));
        planList.add(new Plan(7, "Ir a casa de Ale", "A las 19:00","Torres de Serrano"));
        planList.add(new Plan(8, "Despedida del pisito", "Martes a las 20:00 me voy del piso","El pisito"));
        planList.add(new Plan(1, "KafCafe Open Mic", "Micro abierto en el KafCafé"));
        planList.add(new Plan(2, "Guitarreo en la Playa", "Guitarrita!"));
        planList.add(new Plan(3, "Siesta en el Piso", "Siesta time!"));
        planList.add(new Plan(4, "Quedada para montar en long", "Guitarrita!"));
        planList.add(new Plan(5, "Cervezas en el Bar", "¡Que venga quien quiera!"));
        planList.add(new Plan(5, "Cervezas en el Bar", "¡Que venga quien quiera!"));
        planList.add(new Plan(5, "Cervezas en el Bar", "¡Que venga quien quiera!"));
        planList.add(new Plan(5, "Cervezas en el Bar", "¡Que venga quien quiera!"));
        planList.add(new Plan(5, "Cervezas en el Bar", "¡Que venga quien quiera!"));
    }

}