package com.example.pppr.Room.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pppr.Room.database.Entity.ContentDB;

import java.util.List;

@Dao
public interface ContentDBDao {
    @Insert
    void insert(ContentDB entity);

    @Update
    void update(ContentDB entity);

    @Delete
    void delete(ContentDB publication);


    @Query("SELECT * FROM CONTENTDB WHERE question = :question AND Metnum = :Metnum AND idofview = :idofview")
    List<ContentDB> selectcontent(String question, int Metnum, int idofview);

    @Query("SELECT * FROM CONTENTDB")
    List<ContentDB> findAll();

    @Query("SELECT DISTINCT question FROM ContentDB")
    List<String> findAllDistinctQuestions();

}
