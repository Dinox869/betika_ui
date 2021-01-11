package com.example.betika_ui.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities =  Betting.class,version = 1)
public abstract  class Bettingdatabase extends RoomDatabase {

    public abstract  betDao bdao();

    private static volatile Bettingdatabase bettingdatabase;

    //getting database_instance
    public static  Bettingdatabase getDatabase(final Context context)
    {
        if(bettingdatabase == null)
        {
            synchronized (Bettingdatabase.class)
            {
                if (bettingdatabase == null)
                {
                    bettingdatabase = Room.databaseBuilder(
                            context.getApplicationContext(),
                            Bettingdatabase.class,"bettingdatabases"
                    ).fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return bettingdatabase;
    }

    public static void destroyInstance() {
        bettingdatabase = null;
    }
}
