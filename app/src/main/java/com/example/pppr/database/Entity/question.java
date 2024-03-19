package com.example.pppr.database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "question")
public class question {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "authorId")
    private int authorId;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "title")
    private String title;

}
