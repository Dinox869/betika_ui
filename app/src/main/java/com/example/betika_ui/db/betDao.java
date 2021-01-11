package com.example.betika_ui.db;

import com.example.betika_ui.adapter.checkout_data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface betDao {

    @Insert(onConflict = IGNORE)
    void insert(Betting bets);

    //Get all items
    @Query("SELECT * FROM Betting")
    LiveData<List<Betting>> getAllData();

    @Delete
    int delete(Betting betting);

    //Delete All
    @Query("DELETE FROM Betting")
    void deleteAll();
}
