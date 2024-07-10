package com.example.myjavaroomdb.roomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1)

public abstract class StudentDB extends RoomDatabase {
    public abstract StudentDao getDao();

    public static StudentDB INSTANCE;

    public static StudentDB getInstance(Context context){
        if(INSTANCE  == null){
            INSTANCE = Room.databaseBuilder(context,StudentDB.class,"StudentDatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return INSTANCE;
    }
}
