package com.tfm.planitnow.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.tfm.planitnow.models.Plan;

@Database(entities = {Plan.class}, version = 1, exportSchema = false)
@TypeConverters({DBConverter.class})
public abstract class PlanItNowDatabase extends RoomDatabase {

    private static final String db_name = "pin-database.db";
    private static volatile PlanItNowDatabase instance;


    /* Singleton */
    public static synchronized PlanItNowDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static PlanItNowDatabase create(final Context context){
        return Room.databaseBuilder(
                context,
                PlanItNowDatabase.class,
                db_name).allowMainThreadQueries().build();
    }

    /* Constructor */
    public abstract PlanDao planDao();
}
