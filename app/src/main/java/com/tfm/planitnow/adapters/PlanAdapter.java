package com.tfm.planitnow.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tfm.planitnow.models.Plan;
import com.tfm.planitnow.viewholders.PlanHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanHolder> {

    private List<Plan> allPlans;
    private Context mContext;

    public PlanAdapter(Context context,List<Plan> allPlans){
        this.allPlans = allPlans;
        this.mContext = context;
    }

    @NonNull
    @NotNull
    @Override
    public PlanHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PlanHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
