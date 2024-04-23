package com.example.pppr.database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pppr.MainActivity;
import com.example.pppr.database.Entity.MainEntity;

import java.util.List;

@Dao
public interface MainDao {
    @Insert
    void insertMain(MainEntity mainEntity);

    @Delete
    void delete(MainEntity mainEntity);

    @Query("SELECT * FROM main WHERE question = :savedtext AND idofView = :idofView AND varnum = :varnum ")
    List<MainEntity> findallforView(String savedtext,int idofView, int varnum);

    @Query("SELECT * FROM main")
    List<MainEntity> findAll();

}

