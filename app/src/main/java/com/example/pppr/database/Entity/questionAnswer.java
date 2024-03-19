package com.example.pppr.database.Entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "questionAnswer",foreignKeys = @ForeignKey(entity = question.class,
        parentColumns = "id",
        childColumns = "questionId",
        onDelete = ForeignKey.CASCADE))
public class questionAnswer {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "authorId")
    private int authorId;

    @ColumnInfo(name = "questionId")
    private int questionId;

    @ColumnInfo(name = "content")
    private int content;

}
