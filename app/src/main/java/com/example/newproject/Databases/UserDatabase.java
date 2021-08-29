package com.example.newproject.Databases;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {com.example.newproject.Databases.UserEntity.class}, version = 1)


public abstract class UserDatabase extends RoomDatabase {

    public  abstract UserDao Dao();

    private static final String dbNme="db_user";
    private static UserDatabase userDatabase;

    public static synchronized UserDatabase getUserDatabase(Context context){

        if(userDatabase==null){
            userDatabase= Room.databaseBuilder(context,UserDatabase.class,dbNme)
                    .build();

        }
        return userDatabase;


    }


}





