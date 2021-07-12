package com.tfm.planitnow.database;

import androidx.room.Database;

import com.tfm.planitnow.models.Plan;

@Database(entities = {Plan.class}, version = 1)
public abstract class PlanItNowDatabase {
    public abstract PlanDao planDao();
}
