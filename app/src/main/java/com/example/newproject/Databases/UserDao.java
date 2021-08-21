package com.example.newproject.Databases;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface UserDao
{
    @Insert
    void registerUser(UserEntity userEntity);

    @Query("Select * From Users")
    List<UserEntity> getAllUserEntity();



}
