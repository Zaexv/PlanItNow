package com.tfm.planitnow.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.tfm.planitnow.models.Plan;

import java.util.List;

@Dao
public interface PlanDao {
    @Query("SELECT * FROM plans")
    List<Plan> getAll();

    @Query("SELECT * FROM plans WHERE id IN (:planIds)")
    List<Plan> loadAllByIds(int[] planIds);

    @Query("SELECT * FROM plans where title == (:title)")
    Plan findByTitle(String title);

    @Insert
    void insertAll(Plan... plans);

    @Delete
    void delete(Plan plan);

}
