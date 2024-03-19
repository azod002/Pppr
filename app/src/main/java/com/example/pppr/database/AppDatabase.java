package com.example.pppr.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.pppr.database.Dao.MainDao;
import com.example.pppr.database.Entity.MainEntity;

@Database(entities = { MainEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MainDao getMainDao();
}