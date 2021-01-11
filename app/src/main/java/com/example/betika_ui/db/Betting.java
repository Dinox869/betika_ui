package com.example.betika_ui.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Betting")
public class Betting {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    @ColumnInfo(name = "team1")
    private String team_1;

    @NonNull
    @ColumnInfo(name = "team2")
    private String team_2;

    @NonNull
    @ColumnInfo(name = "betnumber")
    private String bet_number;


    //constructor
    public Betting( String team_1,
                   String team_2, String bet_number)
    {
        this.bet_number = bet_number;
        this.team_1 = team_1;
        this.team_2 = team_2;
    }

    @NonNull
    public int getId() {
        return id;
    }

    @NonNull
    public String getTeam_1() {
        return team_1;
    }

    @NonNull
    public String getTeam_2() {
        return team_2;
    }

    @NonNull
    public String getBet_number() {
        return bet_number;
    }
}
