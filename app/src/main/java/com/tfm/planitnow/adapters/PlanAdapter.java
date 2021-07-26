package com.tfm.planitnow.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tfm.planitnow.R;
import com.tfm.planitnow.models.Plan;
import com.tfm.planitnow.viewholders.PlanHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanHolder> {

    private List<Plan> allPlans;
    private Context mContext;
    LayoutInflater layoutInflater;

    public PlanAdapter(Context context,List<Plan> allPlans){
        this.layoutInflater = LayoutInflater.from(context);
        this.allPlans = allPlans;
        this.mContext = context;
    }

    @NonNull
    @NotNull
    @Override
    public PlanHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        /* Inflate the Rows */
        View view = layoutInflater.inflate(R.layout.list_plans,parent,false);
        
        return new PlanHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PlanHolder holder, int position) {
        final Plan plan = allPlans.get(position);
        holder.bindData(plan);
    }

    @Override
    public int getItemCount() {
        return allPlans == null?0 : allPlans.size();
    }

    /* Functions */
    public void setPlans(List<Plan> listPlans){
        this.allPlans = listPlans;
    }
    public List<Plan> getPlans() { return this.allPlans; }
    public void addPlan(Plan p) { allPlans.add(0, p); }

}
