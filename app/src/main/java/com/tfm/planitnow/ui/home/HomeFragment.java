package com.tfm.planitnow.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tfm.planitnow.R;
import com.tfm.planitnow.activities.CreatePlanActivity;
import com.tfm.planitnow.adapters.PlanAdapter;
import com.tfm.planitnow.database.PlanItNowDatabase;
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

        /* Init button */ //TODO Refactor
        FloatingActionButton fab = root.findViewById(R.id.goto_createplanbutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), CreatePlanActivity.class);
                root.getContext().startActivity(i);
            }
        });

        //homeViewModel.loadPlansFromDB(this.getContext());
        homeViewModel.loadPlansFromGraphQL();

        initializePlanAdapter(root);
        return root;
    }

    private void initializePlanAdapter(View root) {
        planAdapter = new PlanAdapter(this.getContext(),homeViewModel.getPlanList());
        RecyclerView recyclerView = root.findViewById(R.id.listPlanRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(planAdapter);
    }

    public static void addPlan(Plan p){
        homeViewModel.addPlan(p);
        planAdapter.notifyDataSetChanged();
    }

    public static void deletePlan(Plan p, Context context){
        homeViewModel.deletePlan(p);
        PlanItNowDatabase.getInstance(context).planDao().delete(p);
        planAdapter.notifyDataSetChanged();
    }



}