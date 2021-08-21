package com.example.newproject.Databases;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {com.example.newproject.Databases.UserEntity.class}, version = 1)


public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao Dao();

    private static volatile UserDatabase INSTANCE;

    public static UserDatabase getINSTANCE(Context context) {

        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context, UserDatabase.class, "DB_NAME").build();
                }
            }

        }
        return INSTANCE;
    }

}



