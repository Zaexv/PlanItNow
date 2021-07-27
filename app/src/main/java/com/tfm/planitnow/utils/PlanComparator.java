package com.tfm.planitnow.utils;

import com.tfm.planitnow.models.Plan;

import java.util.Comparator;

public class PlanComparator implements Comparator<Plan> {

    @Override
    public int compare(Plan plan, Plan t1) {
        int res = plan.getInit_date().compareTo(t1.getInit_date());
        if(res == 0)
            res = plan.getInit_hour().compareTo(t1.getInit_hour());
        return res;
    }
}
