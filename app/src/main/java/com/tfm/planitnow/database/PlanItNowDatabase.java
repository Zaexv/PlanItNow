package com.tfm.planitnow.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tfm.planitnow.models.Plan;

@Database(entities = {Plan.class}, version = 1)
public abstract class PlanItNowDatabase extends RoomDatabase {
    public abstract PlanDao planDao();
}
