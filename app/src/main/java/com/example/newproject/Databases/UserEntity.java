package com.example.newproject.Databases;


import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "Users")
 public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    int uid;

    @ColumnInfo
    String username;

    @ColumnInfo
    String email;

    @ColumnInfo
    String password;

    @ColumnInfo
    String confirmpassword;

   public int getUid() {
      return uid;
   }

   public void setUid(int uid) {
      this.uid = uid;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getConfirmpassword() {
      return confirmpassword;
   }

   public void setConfirmpassword(String confirmpassword) {
      this.confirmpassword = confirmpassword;
   }
}
