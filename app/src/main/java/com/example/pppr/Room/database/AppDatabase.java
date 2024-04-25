package com.example.pppr.Room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.pppr.Room.database.DAO.ContentDBDao;
import com.example.pppr.Room.database.Entity.ContentDB;

@Database(entities = { ContentDB.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContentDBDao getContentDao();
}
