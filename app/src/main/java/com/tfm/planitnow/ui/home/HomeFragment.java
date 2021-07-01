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


    private static HomeViewModel homeViewModel;
    private static PlanAdapter planAdapter;

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

        /* Init button */ //TODO Refactor
        FloatingActionButton fab = root.findViewById(R.id.goto_createplanbutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), CreatePlanActivity.class);
                root.getContext().startActivity(i);
            }
        });

        planAdapter = new PlanAdapter(this.getContext(),homeViewModel.getPlanList());
        RecyclerView recyclerView = root.findViewById(R.id.listPlanRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(planAdapter);
        return root;
    }

    public static void addPlan(Plan p){
        homeViewModel.addPlan(p);
        planAdapter.notifyDataSetChanged();
    }



}