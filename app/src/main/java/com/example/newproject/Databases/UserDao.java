package com.example.newproject.Databases;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface UserDao
{
    @Insert
    void registerUser(UserEntity userEntity);

    @Query("Select * From Users")
    List<UserEntity> getAllUserEntity();

    @Query("Select * from Users where email = (:email) and password = (:password)")
    UserEntity loginUser(String email, String password);

    @Update
    void updateUser(UserEntity userEntity);

    @Delete
    void deleteUser(UserEntity userEntity);

    @Query("Select * from Users where uid = (:iD)")
    UserEntity getId (int iD);



}
